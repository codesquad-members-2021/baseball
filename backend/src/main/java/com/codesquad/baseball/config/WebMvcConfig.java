package com.codesquad.baseball.config;

import com.codesquad.baseball.service.JwtBuilder;
import com.codesquad.baseball.service.JwtVerifier;
import com.codesquad.baseball.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final JwtVerifier jwtVerifier;

    public WebMvcConfig(JwtVerifier jwtVerifier) {
        this.jwtVerifier = jwtVerifier;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(jwtVerifier))
                .addPathPatterns("/**")
                .excludePathPatterns("/users/**");

        registry.addInterceptor(new RefreshInterceptor(jwtVerifier))
                .addPathPatterns("/users/**");
    }
}
