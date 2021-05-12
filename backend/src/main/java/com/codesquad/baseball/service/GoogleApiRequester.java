package com.codesquad.baseball.service;

import com.codesquad.baseball.dto.oauth.ReceiveAccessTokenDTO;
import com.codesquad.baseball.dto.oauth.RequestAccessTokenDTO;
import com.codesquad.baseball.dto.oauth.UserInfoDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static com.codesquad.baseball.utils.UrlConstant.*;

@Service
public class GoogleApiRequester {

    private final RestTemplate restTemplate;
    private final OAuthManager oAuthManager;

    public GoogleApiRequester(RestTemplateBuilder templateBuilder, OAuthManager oAuthManager) {
        this.restTemplate = templateBuilder.build();
        this.oAuthManager = oAuthManager;
    }

    public ReceiveAccessTokenDTO requestAccessToken(String authorizationCode) {
        RequestAccessTokenDTO requestAccessTokenDTO = new RequestAccessTokenDTO(oAuthManager.clientId(), oAuthManager.clientSecret(), authorizationCode, REDIRECT_URI);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<RequestAccessTokenDTO> httpEntity = new HttpEntity<>(requestAccessTokenDTO, httpHeaders);
        return restTemplate.exchange(GOOGLE_API_GET_ACCESS_TOKEN, HttpMethod.POST, httpEntity, ReceiveAccessTokenDTO.class).getBody();
    }

    public UserInfoDTO requestUserInfo(String accessToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setBearerAuth(accessToken);
        HttpEntity<?> userInfoHttpEntity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(GOOGLE_API_GET_USER_INFO, HttpMethod.GET, userInfoHttpEntity, UserInfoDTO.class).getBody();
    }
}
