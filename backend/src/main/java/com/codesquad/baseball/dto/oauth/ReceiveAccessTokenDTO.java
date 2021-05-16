package com.codesquad.baseball.dto.oauth;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ReceiveAccessTokenDTO {

    private String accessToken;
    private int expiresIn;
    private String scope;
    private String tokenType;
    private String idToken;

    public ReceiveAccessTokenDTO() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getIdToken() {
        return idToken;
    }

    @Override
    public String toString() {
        return "ReceiveAccessTokenDTO{" +
                "access_token='" + accessToken + '\'' +
                ", expires_in=" + expiresIn +
                ", scope='" + scope + '\'' +
                ", token_type='" + tokenType + '\'' +
                ", id_token='" + idToken + '\'' +
                '}';
    }
}
