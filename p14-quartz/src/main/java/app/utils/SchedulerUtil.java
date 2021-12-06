package app.utils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Author: bai
 * @Date: 2021/12/3 17:30
 *
 * https://blog.csdn.net/weixin_45478355/article/details/106871717
 *
 * https://blog.csdn.net/u011786674/article/details/105537665?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link
 */
@AllArgsConstructor
@Slf4j
@Component
public class SchedulerUtil {

    private final Scheduler scheduler;

    /**
     * 创建定时任务
     * @param jobGroup
     * @param jobName
     * @param clazz
     * @param cronExpression
     * @param params
     */
    public void createJob(String jobGroup, String jobName, Class<? extends Job> clazz, String cronExpression, Map<String,Object> params) throws SchedulerException {
        if(scheduler.checkExists(JobKey.jobKey(jobName,jobGroup))){
            throw new SchedulerException(String.format("JobGroup:%s ,JobName:%s 已存在",jobGroup,jobName));
        }
        //构建 job 信息
        JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(jobName,jobGroup).build();
        //表达式调度器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
       // 构建一个新的 trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName,jobGroup).withSchedule(scheduleBuilder).build();
        if(!CollectionUtils.isEmpty(params)){
            jobDetail.getJobDataMap().putAll(params);
        }
        Date date = scheduler.scheduleJob(jobDetail,trigger);
        log.info("创建定时任务成功： cron = {},date = {}",cronExpression,date);
    }

    /**
     * 检查定时任务是否存在
     * @param jobGroup
     * @param jobName
     * @return
     * @throws SchedulerException
     */
    public boolean isExistJob(String jobGroup,String jobName)throws SchedulerException{
        return scheduler.checkExists(JobKey.jobKey(jobName,jobGroup));
    }

    /**
     * 暂停定时任务
     * @param jobGroup
     * @param jobName
     * @throws SchedulerException
     */
    public void pauseJob(String jobName,String jobGroup) throws SchedulerException{
        JobKey jobKey =JobKey.jobKey(jobName,jobGroup);
        if(!scheduler.checkExists(jobKey)){
            throw new SchedulerException(String.format("JobGroup: %s ,JobName: %s 不存在",jobGroup,jobName));
        }
        scheduler.pauseJob(jobKey);
        log.info("暂停定时任务成功，JobGroup:{} ,JobName:{}",jobGroup,jobName);
    }

    /**
     * 恢复定时任务
     * @param jobGroup
     * @param jobName
     * @throws SchedulerException
     */
    public void resumeJob(String jobGroup,String jobName) throws SchedulerException{
        JobKey jobKey =JobKey.jobKey(jobName,jobGroup);
        if(!scheduler.checkExists(jobKey)){
            throw new SchedulerException(String.format("JobGroup:%s ,JobName:%s 不存在",jobGroup,jobName));
        }
        scheduler.resumeJob(jobKey);
        log.info("恢复定时任务成功，JobGroup:{} ,JobName:{}",jobGroup,jobName);
    }

    /**
     * 删除定时任务
     * @param jobGroup
     * @param jobName
     * @throws SchedulerException
     */
    public void deleteJob(String jobGroup,String jobName) throws SchedulerException{
        JobKey jobKey =JobKey.jobKey(jobName,jobGroup);
        if(!scheduler.checkExists(jobKey)){
            throw new SchedulerException(String.format("JobGroup:%s ,JobName:%s 不存在",jobGroup,jobName));
        }
        boolean isDelete = scheduler.deleteJob(jobKey);
        log.info("删除定时任务{}，JobGroup:{},JobName:{}",isDelete ?"成功":"失败",jobGroup,jobName);
    }



}















