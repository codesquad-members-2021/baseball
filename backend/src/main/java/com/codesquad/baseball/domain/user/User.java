package com.codesquad.baseball.domain.user;

import com.codesquad.baseball.dto.oauth.UserInfoDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERS")
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
    private String jwt;

    protected User() {
    }

    public User(UserInfoDTO userInfoDTO) {
        userId = userInfoDTO.getId();
        email = userInfoDTO.getEmail();
        verifiedEmail = userInfoDTO.getVerified_email();
        name = userInfoDTO.getName();
        familyName = userInfoDTO.getFamily_name();
        givenName = userInfoDTO.getGiven_name();
        picture = userInfoDTO.getPicture();
        locale = userInfoDTO.getLocale();
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

    public void updateToken(String jwt) {
        this.jwt = jwt;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getJwt() {
        return jwt;
    }
}
