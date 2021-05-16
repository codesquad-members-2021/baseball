package com.codesquad.baseball.config;

import com.codesquad.baseball.dto.oauth.RefreshTokenDTO;
import com.codesquad.baseball.service.JwtVerifier;
import com.codesquad.baseball.utils.TokenUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefreshInterceptor implements HandlerInterceptor {

    public static final String USER_ID_KEY = "USER_ID";

    @Resource
    private JwtVerifier jwtVerifier;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            onRefreshAnnotation(request);
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

    private void onRefreshAnnotation(HttpServletRequest request) {
        RefreshTokenDTO refreshTokenDTO = verifyRefreshToken(request);
        jwtVerifier.verifyRefreshToken(refreshTokenDTO);
        request.setAttribute(USER_ID_KEY, refreshTokenDTO.getUserId());
    }

    private RefreshTokenDTO verifyRefreshToken(HttpServletRequest request) {
        String jwtToken = TokenUtil.extractTokenFromHeader(request);
        String userId = jwtVerifier.extractUserIdFromJwt(jwtToken);
        return new RefreshTokenDTO.Builder()
                .userId(userId)
                .refreshToken(jwtToken)
                .build();
    }
}
