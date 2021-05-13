package com.codesquad.baseball.dto.oauth;

public class RefreshTokenDTO {

    private String userId;
    private String refreshToken;

    public RefreshTokenDTO(Builder builder) {
        this.userId = builder.userId;
        this.refreshToken = builder.refreshToken;
    }

    public static class Builder {

        private String userId;
        private String refreshToken;

        public Builder userId(String value) {
            userId = value;
            return this;
        }

        public Builder refreshToken(String value) {
            refreshToken = value;
            return this;
        }

        public RefreshTokenDTO build() {
            return new RefreshTokenDTO(this);
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
