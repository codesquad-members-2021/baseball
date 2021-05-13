package com.codesquad.baseball.dto.oauth;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class JwtTokenDTO {

    private String userId;
    private String accessToken;
    private String refreshToken;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date accessTokenExpirationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date refreshTokenExpirationDate;

    public JwtTokenDTO(Builder builder) {
        this.userId = builder.userId;
        this.accessToken = builder.accessToken;
        this.refreshToken = builder.refreshToken;
        this.accessTokenExpirationDate = builder.accessTokenExpirationDate;
        this.refreshTokenExpirationDate = builder.refreshTokenExpirationDate;
    }

    public String getUserId() {
        return userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public Date getAccessTokenExpirationDate() {
        return accessTokenExpirationDate;
    }

    public Date getRefreshTokenExpirationDate() {
        return refreshTokenExpirationDate;
    }

    public static class Builder {

        private String userId;
        private String accessToken;
        private String refreshToken;
        private Date accessTokenExpirationDate;
        private Date refreshTokenExpirationDate;

        public Builder userId(String value) {
            userId = value;
            return this;
        }

        public Builder accessToken(String value) {
            accessToken = value;
            return this;
        }

        public Builder refreshToken(String value) {
            refreshToken = value;
            return this;
        }

        public Builder accessTokenExpirationDate(Date value) {
            accessTokenExpirationDate = value;
            return this;
        }

        public Builder refreshTokenExpirationDate(Date value) {
            refreshTokenExpirationDate = value;
            return this;
        }

        public JwtTokenDTO build() {
            return new JwtTokenDTO(this);
        }
    }
}
