package com.codesquad.baseball.config;

import com.codesquad.baseball.annotation.Auth;
import com.codesquad.baseball.dto.oauth.AccessTokenDTO;
import com.codesquad.baseball.service.JwtVerifier;
import com.codesquad.baseball.utils.TokenUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

    public static final String USER_ID_KEY = "USER_ID";
    private static final int BEARER_TOKEN_LENGTH = 2;
    private static final int TOKEN = 1;
    private final JwtVerifier jwtVerifier;

    public AuthInterceptor(JwtVerifier jwtVerifier) {
        this.jwtVerifier = jwtVerifier;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod) {
            processAuth(request, handler);
        }
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

    private void onAuthAnnotation(HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = extractAccessTokenDtoFromRequest(request);
        jwtVerifier.verifyAccessToken(accessTokenDTO);
        request.setAttribute(USER_ID_KEY, accessTokenDTO.getUserId());
    }

    private void processAuth(HttpServletRequest request, Object handler) {
        Auth authAnnotation = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
        if (authAnnotation != null) {
            onAuthAnnotation(request);
        }
    }

    private AccessTokenDTO extractAccessTokenDtoFromRequest(HttpServletRequest request) {
        String jwtToken = TokenUtil.extractTokenFromHeader(request);
        String userId = jwtVerifier.extractUserIdFromJwt(jwtToken);
        return new AccessTokenDTO.Builder()
                .userId(userId)
                .accessToken(jwtToken)
                .build();
    }
}
