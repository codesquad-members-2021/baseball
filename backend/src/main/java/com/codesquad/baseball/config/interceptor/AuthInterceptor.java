package com.codesquad.baseball.config.interceptor;

import com.codesquad.baseball.domain.user.User;
import com.codesquad.baseball.dto.oauth.AccessTokenDTO;
import com.codesquad.baseball.service.JwtVerifier;
import com.codesquad.baseball.service.UserService;
import com.codesquad.baseball.utils.TokenUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.codesquad.baseball.utils.ArgumentResolverKeyConstant.CERTIFIED_USER;
import static com.codesquad.baseball.utils.ArgumentResolverKeyConstant.USER_ID_KEY;

public class AuthInterceptor implements HandlerInterceptor {

    @Resource
    private JwtVerifier jwtVerifier;

    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            onAuthAnnotation(request);
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
        User certifiedUser = userService.findUserByUserId(accessTokenDTO.getUserId());
        request.setAttribute(CERTIFIED_USER, certifiedUser);
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
