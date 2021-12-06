package app.controller;

import app.job.DemoJob;
import app.model.JobInfo;
import app.utils.SchedulerUtil;
import lombok.AllArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: bai
 * @Date: 2021/12/3 15:41
 */
@AllArgsConstructor
@RestController
public class TestController {

    private final SchedulerUtil schedulerUtil;

    @PostMapping("/createJob")
    public String createJob(@RequestBody JobInfo jobInfo) throws SchedulerException {
        schedulerUtil.createJob(
                jobInfo.getJobGroup(),
                jobInfo.getJobName(),
                DemoJob.class,
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
}
