package com.codesquad.baseball.dto.oauth;

public class AccessTokenDTO {

    private String userId;
    private String accessToken;

    public AccessTokenDTO(Builder builder) {
        this.userId = builder.userId;
        this.accessToken = builder.accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public static class Builder {

        private String userId;
        private String accessToken;

        public Builder userId(String value) {
            userId = value;
            return this;
        }

        public Builder accessToken(String value) {
            accessToken = value;
            return this;
        }

        public AccessTokenDTO build() {
            return new AccessTokenDTO(this);
        }
    }
}
