package com.codesquad.baseball.config;

import com.codesquad.baseball.config.interceptor.AuthInterceptor;
import com.codesquad.baseball.config.interceptor.RefreshInterceptor;
import com.codesquad.baseball.config.resolver.CertifiedUserResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/games/{gameId}/**");

        registry.addInterceptor(refreshInterceptor())
                .addPathPatterns("/users/refreshToken");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(certifiedUserResolver());
    }

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    public RefreshInterceptor refreshInterceptor() {
        return new RefreshInterceptor();
    }

    @Bean
    public CertifiedUserResolver certifiedUserResolver() {
        return new CertifiedUserResolver();
    }
}
