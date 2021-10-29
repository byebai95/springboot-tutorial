package app.config;

import app.config.po.AuthFilter;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: bai
 * @Date: 2021/10/29 11:05
 */
@AllArgsConstructor
@Configuration
public class FilterConfig {

    private final AuthFilter authFilter;

    @Bean
    public FilterRegistrationBean<AuthFilter> filterRegistrationBean(){
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(authFilter);
        registrationBean.addUrlPatterns("/login/check/*");
        return registrationBean;
    }


}
