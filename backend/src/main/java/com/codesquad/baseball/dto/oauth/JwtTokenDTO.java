package com.codesquad.baseball.dto.oauth;

import com.codesquad.baseball.domain.user.User;

public class JwtTokenDTO {

    private String userId;
    private String jwt;

    private JwtTokenDTO(String userId, String jwt) {
        this.userId = userId;
        this.jwt = jwt;
    }

    public static JwtTokenDTO from(User user) {
        return new JwtTokenDTO(user.getUserId(), user.getJwt());
    }

    public String getUserId() {
        return userId;
    }

    public String getJwt() {
        return jwt;
    }
}
