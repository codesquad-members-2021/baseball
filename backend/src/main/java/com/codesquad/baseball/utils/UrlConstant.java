package com.codesquad.baseball.utils;

import com.codesquad.baseball.service.OAuthManager;
import org.springframework.stereotype.Service;

@Service
public class UrlConstant {

    //GOOGLE APIS
    private static final String GOOGLE_API_GET_LOGIN_PAGE = "https://accounts.google.com/o/oauth2/v2/auth";
    public static final String GOOGLE_API_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo";
    public static final String GOOGLE_API_GET_ACCESS_TOKEN = "https://oauth2.googleapis.com/token";
    //GOOGLE SCOPES
    public static final String GOOGLE_SCOPE_EMAIL = "https://www.googleapis.com/auth/userinfo.email";
    public static final String GOOGLE_SCOPE_PROFILE = "https://www.googleapis.com/auth/userinfo.profile";
    public static final String REDIRECT_URI = "http://localhost:8080/users/callback";

    private final OAuthManager oAuthManager;

    public UrlConstant(OAuthManager oAuthManager) {
        this.oAuthManager = oAuthManager;
    }


    public String loginPageUrl() {
        return GOOGLE_API_GET_LOGIN_PAGE + "?" +
                "client_id=" + oAuthManager.clientId() +
                "&redirect_uri=" + REDIRECT_URI +
                "&response_type=code" +
                "&scope=" + GOOGLE_SCOPE_EMAIL + " " + GOOGLE_SCOPE_PROFILE;
    }
}
