package com.liuxing.common.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private JwtInterceptor jwtInterceptor;

    /**
     * APP接口拦截器
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //排除swagger的页面拦截
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }
}
