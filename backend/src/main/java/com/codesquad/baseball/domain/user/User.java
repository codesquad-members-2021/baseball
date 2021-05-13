package com.codesquad.baseball.domain.user;

import com.codesquad.baseball.dto.oauth.JwtTokenDTO;
import com.codesquad.baseball.dto.oauth.UserInfoDTO;
import com.codesquad.baseball.exceptions.oauth.InvalidAccessTokenException;
import com.codesquad.baseball.exceptions.oauth.InvalidRefreshTokenException;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class User {

    @Id
    private Long id;
    private String userId;
    private String email;
    private String verifiedEmail;
    private String name;
    private String familyName;
    private String givenName;
    private String picture;
    private String locale;
    private String accessToken;
    private String refreshToken;

    protected User() {
    }

    public User(UserInfoDTO userInfoDTO, JwtTokenDTO jwtTokenDTO) {
        userId = userInfoDTO.getId();
        email = userInfoDTO.getEmail();
        verifiedEmail = userInfoDTO.getVerified_email();
        name = userInfoDTO.getName();
        familyName = userInfoDTO.getFamily_name();
        givenName = userInfoDTO.getGiven_name();
        picture = userInfoDTO.getPicture();
        locale = userInfoDTO.getLocale();
        this.accessToken = jwtTokenDTO.getAccessToken();
        this.refreshToken = jwtTokenDTO.getRefreshToken();
    }

    public void update(UserInfoDTO userInfoDTO) {
        userId = userInfoDTO.getId();
        email = userInfoDTO.getEmail();
        verifiedEmail = userInfoDTO.getVerified_email();
        name = userInfoDTO.getName();
        familyName = userInfoDTO.getFamily_name();
        givenName = userInfoDTO.getGiven_name();
        picture = userInfoDTO.getPicture();
        locale = userInfoDTO.getLocale();
    }

    public void verifyAccessToken(String accessToken) {
        if (!this.accessToken.equals(accessToken)) {
            throw new InvalidAccessTokenException(InvalidAccessTokenException.INVALID_ACCESS_TOKEN);
        }
    }

    public void verifyRefreshToken(String refreshToken) {
        if (!this.refreshToken.equals(refreshToken)) {
            throw new InvalidRefreshTokenException(InvalidRefreshTokenException.INVALID_REFRESH_TOKEN);
        }
    }

    public void updateAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getId() {
        return id;
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
}
