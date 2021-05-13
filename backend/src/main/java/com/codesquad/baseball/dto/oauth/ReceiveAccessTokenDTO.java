package com.codesquad.baseball.dto.oauth;

public class ReceiveAccessTokenDTO {

    private String access_token;
    private int expires_in;
    private String scope;
    private String token_type;
    private String id_token;

    public ReceiveAccessTokenDTO() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getScope() {
        return scope;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getId_token() {
        return id_token;
    }

    @Override
    public String toString() {
        return "ReceiveAccessTokenDTO{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", scope='" + scope + '\'' +
                ", token_type='" + token_type + '\'' +
                ", id_token='" + id_token + '\'' +
                '}';
    }
}
