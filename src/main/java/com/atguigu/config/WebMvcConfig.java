package com.atguigu.config;

import com.atguigu.interceptors.Demo01Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 包名:com.atguigu.config
 *
 * @author Leevi
 * 日期2023-09-11  10:26
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private Demo01Interceptor demo01Interceptor;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOriginPatterns("*")
                .allowCredentials(true);

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demo01Interceptor)
                .addPathPatterns("/**");
    }
}
