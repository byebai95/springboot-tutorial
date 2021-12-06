package app.controller;

import app.job.DemoJob;
import app.mapper.EmpMapper;
import app.model.Emp;
import app.model.JobInfo;
import app.utils.SchedulerUtil;
import lombok.AllArgsConstructor;
import org.quartz.Job;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: bai
 * @Date: 2021/12/3 15:41
 */
@AllArgsConstructor
@RestController
public class TestController {

    private final SchedulerUtil schedulerUtil;

    private final EmpMapper empMapper;

    @PostMapping("/createJob")
    public String createJob(@RequestBody JobInfo jobInfo) throws Exception{
        Class clazz = Class.forName(jobInfo.getClazz());
        schedulerUtil.createJob(
                jobInfo.getJobGroup(),
                jobInfo.getJobName(),
                clazz,
                jobInfo.getCronExpression(),
                jobInfo.getParams());
        return "创建定时任务成功";
    }

    @PostMapping("/pauseJob")
    public String pauseJob(@RequestBody JobInfo jobInfo) throws SchedulerException{
        schedulerUtil.pauseJob(jobInfo.getJobName(),jobInfo.getJobGroup());
        return "暂停定时任务成功";
    }

    @PostMapping("/resumeJob")
    public String resumeJob(@RequestBody JobInfo jobInfo) throws SchedulerException{
        schedulerUtil.resumeJob(jobInfo.getJobGroup(),jobInfo.getJobName());
        return "恢复定时任务成功";
    }

    @PostMapping("/deleteJob")
    public String deleteJob(@RequestBody JobInfo jobInfo) throws SchedulerException{
        schedulerUtil.deleteJob(jobInfo.getJobGroup(),jobInfo.getJobName());
        return "删除定时任务成功";
    }

    @PostMapping("/isExistJob")
    public String isExistJob(@RequestBody JobInfo jobInfo) throws SchedulerException{
        boolean isExist = schedulerUtil.isExistJob(jobInfo.getJobGroup(),jobInfo.getJobName());
        return isExist ? "任务已存在":"任务不存在";
    }

    /**
     * 分库查询测试
     * @return
     */
    @GetMapping("/list")
    public List<Emp> list(){
        return empMapper.list();
    }
}
