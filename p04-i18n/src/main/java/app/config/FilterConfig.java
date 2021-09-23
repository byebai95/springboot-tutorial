package app.config;

import app.manager.CommonParamFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<CommonParamFilter> paramFilterFilterRegistrationBean(){
        FilterRegistrationBean<CommonParamFilter> paramFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        CommonParamFilter paramFilter = new CommonParamFilter();
        paramFilterFilterRegistrationBean.setFilter(paramFilter);
        paramFilterFilterRegistrationBean.setUrlPatterns(Collections.singleton("/*"));
        paramFilterFilterRegistrationBean.setOrder(1);
        return paramFilterFilterRegistrationBean;
    }
}
