package app.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author: bai
 * @Date: 2021/12/3 16:13
 */
@Slf4j
@Configuration
public class DataSourceConfig {

    /**
     * 数据源配置的前缀，必须与application.properties中配置的对应数据源的前缀一致
     */
    private static final String BUSINESS_DATASOURCE_PREFIX = "spring.datasource.druid.business";

    private static final String QUARTZ_DATASOURCE_PREFIX = "spring.datasource.druid.quartz";


    @Primary
    @Bean(name = "dbDataSource")
    @ConfigurationProperties(prefix = BUSINESS_DATASOURCE_PREFIX)
    public DruidDataSource businessDataSource(){
        return new DruidDataSourceBuilder().build();
    }

    @Bean
    @QuartzDataSource
    @ConfigurationProperties(prefix = QUARTZ_DATASOURCE_PREFIX)
    public DruidDataSource quartzDataSource(){
        return new DruidDataSourceBuilder().build();
    }

}
