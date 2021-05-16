package com.codesquad.baseball.config;

import com.codesquad.baseball.service.JwtVerifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/users/**");

        registry.addInterceptor(refreshInterceptor())
                .addPathPatterns("/users/**");
    }

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    public RefreshInterceptor refreshInterceptor() {
        return new RefreshInterceptor();
    }
}
