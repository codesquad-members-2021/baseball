package com.codesquad.baseball.config;

import com.codesquad.baseball.annotation.Auth;
import com.codesquad.baseball.exceptions.oauth.InvalidJwtTokenException;
import com.codesquad.baseball.exceptions.oauth.NoJwtTokenException;
import com.codesquad.baseball.service.JwtManager;
import org.springframework.ui.Model;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

    private static final int BEARER_TOKEN_LENGTH = 2;
    private static final int TOKEN = 1;
    public static final String USER_ID_KEY = "USER_ID";

    private final JwtManager jwtManager;

    public AuthInterceptor(JwtManager jwtManager) {
        this.jwtManager = jwtManager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Auth authAnnotation = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
        if (authAnnotation == null) {
            return true;
        }
        String userId = validateToken(request);
        request.setAttribute(USER_ID_KEY, userId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    private String validateToken(HttpServletRequest request) {
        String authorizationValue = request.getHeader("Authorization");
        if (authorizationValue == null || authorizationValue.isEmpty()) {
            throw new NoJwtTokenException(NoJwtTokenException.NO_TOKEN_IN_REQUEST_HEADER);
        }
        String[] splitedString = authorizationValue.split(" ");
        if (splitedString.length != BEARER_TOKEN_LENGTH) {
            throw new InvalidJwtTokenException(InvalidJwtTokenException.BAD_TOKEN);
        }
        String jwtToken = splitedString[TOKEN];

        return jwtManager.extractUserIdFromJwt(jwtToken);
    }
}
