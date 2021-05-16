package com.codesquad.baseball.controller;

import com.codesquad.baseball.config.annotation.CertifiedUser;
import com.codesquad.baseball.domain.user.User;
import com.codesquad.baseball.dto.oauth.AuthorizationInfo;
import com.codesquad.baseball.dto.oauth.JwtTokenDTO;
import com.codesquad.baseball.dto.oauth.ReceiveAccessTokenDTO;
import com.codesquad.baseball.dto.oauth.UserInfoDTO;
import com.codesquad.baseball.service.GoogleApiRequester;
import com.codesquad.baseball.service.GoogleUrlService;
import com.codesquad.baseball.service.JwtBuilder;
import com.codesquad.baseball.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.NOT_MODIFIED)
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect(googleUrlService.loginPageUrl());
    }

    @GetMapping("/callback")
    public JwtTokenDTO oauthCallBack(AuthorizationInfo authorizationInfo) {
        ReceiveAccessTokenDTO receiveAccessTokenDTO = googleApiRequester.requestAccessToken(authorizationInfo.getCode());
        UserInfoDTO userInfoDTO = googleApiRequester.requestUserInfo(receiveAccessTokenDTO.getAccessToken());
        return userService.login(userInfoDTO);
    }

    @PostMapping("/refreshToken")
    public JwtTokenDTO refreshToken(@CertifiedUser User certifiedUser) {
        return userService.refreshToken(certifiedUser);
    }
}
