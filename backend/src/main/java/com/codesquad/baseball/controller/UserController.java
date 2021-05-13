package com.codesquad.baseball.controller;

import com.codesquad.baseball.annotation.Refresh;
import com.codesquad.baseball.dto.oauth.AuthorizationInfo;
import com.codesquad.baseball.dto.oauth.JwtTokenDTO;
import com.codesquad.baseball.dto.oauth.ReceiveAccessTokenDTO;
import com.codesquad.baseball.dto.oauth.UserInfoDTO;
import com.codesquad.baseball.service.GoogleApiRequester;
import com.codesquad.baseball.service.GoogleUrlService;
import com.codesquad.baseball.service.JwtBuilder;
import com.codesquad.baseball.service.UserService;
import com.codesquad.baseball.utils.ControllerUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final GoogleApiRequester googleApiRequester;
    private final UserService userService;
    private final GoogleUrlService googleUrlService;
    private final JwtBuilder jwtBuilder;

    public UserController(GoogleApiRequester googleApiRequester, UserService userService, GoogleUrlService googleUrlService, JwtBuilder jwtBuilder) {
        this.googleApiRequester = googleApiRequester;
        this.userService = userService;
        this.googleUrlService = googleUrlService;
        this.jwtBuilder = jwtBuilder;
    }

    @GetMapping("/login")
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect(googleUrlService.loginPageUrl());
    }

    @GetMapping("/callback")
    public JwtTokenDTO oauthCallBack(AuthorizationInfo authorizationInfo) {
        ReceiveAccessTokenDTO receiveAccessTokenDTO = googleApiRequester.requestAccessToken(authorizationInfo.getCode());
        UserInfoDTO userInfoDTO = googleApiRequester.requestUserInfo(receiveAccessTokenDTO.getAccess_token());
        return userService.login(userInfoDTO);
    }

    @Refresh
    @PostMapping("/refreshToken")
    public JwtTokenDTO refreshToken(HttpServletRequest request) {
        String userId = ControllerUtil.extractUserIdFromRequest(request);
        return userService.refreshToken(userId);
    }
}
