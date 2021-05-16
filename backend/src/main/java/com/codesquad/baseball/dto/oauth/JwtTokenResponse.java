package com.codesquad.baseball.dto.oauth;

public class JwtTokenResponse {
    private String token;

    public JwtTokenResponse() {
    }

    public JwtTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
