package app.config;

import lombok.AllArgsConstructor;
import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Author: bai
 * @Date: 2021/12/6 10:10
 */
@AllArgsConstructor
@Configuration
public class SchedulerConfig {

    private final SchedulerFactoryBean schedulerFactoryBean;

    @Bean(name = "scheduler")
    public Scheduler getScheduler(){
        return schedulerFactoryBean.getScheduler();
    }
}
