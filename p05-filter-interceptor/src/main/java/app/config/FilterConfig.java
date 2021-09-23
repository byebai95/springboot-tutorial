package app.config;

import app.manager.ParamFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Collections;


@Configuration
public class FilterConfig{

    @Bean
    public FilterRegistrationBean<ParamFilter> paramFilterFilterRegistrationBean(){
        FilterRegistrationBean<ParamFilter> paramFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        ParamFilter paramFilter = new ParamFilter();
        paramFilterFilterRegistrationBean.setFilter(paramFilter);
        paramFilterFilterRegistrationBean.setUrlPatterns(Collections.singleton("/*"));
        paramFilterFilterRegistrationBean.setOrder(1);
        return paramFilterFilterRegistrationBean;
    }
}
