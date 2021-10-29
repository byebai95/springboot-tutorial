package app.config;

import app.config.po.AuthInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * 拦截器暂时不开启
 * @Author: bai
 * @Date: 2021/10/29 11:31
 */
//@AllArgsConstructor
//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

//
//    private final AuthInterceptor authInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor).addPathPatterns("/login/*").excludePathPatterns("/login/login/*");
//    }
}
