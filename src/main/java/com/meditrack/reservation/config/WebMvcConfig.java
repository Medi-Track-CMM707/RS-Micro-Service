package com.meditrack.reservation.config;

import com.meditrack.reservation.interceptor.HeaderInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final HeaderInterceptor headerInterceptor;

    public WebMvcConfig(HeaderInterceptor headerInterceptor) {
        this.headerInterceptor = headerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Add your custom interceptor
        registry.addInterceptor(headerInterceptor);
    }
}
