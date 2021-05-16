package com.codesquad.baseball.dto.oauth;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming
public class RequestAccessTokenDTO {

    private static final String GRANT_TYPE = "authorization_code";

    private String clientId;
    private String clientSecret;
    private String code;
    private String grantType;
    private String redirectUri;

    public RequestAccessTokenDTO() {
    }

    public RequestAccessTokenDTO(String clientId, String client_secret, String code, String redirectUri) {
        this.clientId = clientId;
        this.clientSecret = client_secret;
        this.code = code;
        this.grantType = GRANT_TYPE;
        this.redirectUri = redirectUri;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getCode() {
        return code;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getRedirectUri() {
        return redirectUri;
    }
}
