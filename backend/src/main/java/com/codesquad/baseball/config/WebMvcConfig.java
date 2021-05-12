package com.codesquad.baseball.config;

import com.codesquad.baseball.service.JwtManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final JwtManager jwtManager;

    public WebMvcConfig(JwtManager jwtManager) {
        this.jwtManager = jwtManager;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(jwtManager))
                .addPathPatterns("/**")
                .excludePathPatterns("/users");
    }
}
