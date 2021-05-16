package com.codesquad.baseball.dto.oauth;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfoDTO {
    private String id;
    private String email;
    private String verifiedEmail;
    private String name;
    private String familyName;
    private String givenName;
    private String picture;
    private String locale;

    public UserInfoDTO() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getVerifiedEmail() {
        return verifiedEmail;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getPicture() {
        return picture;
    }

    public String getLocale() {
        return locale;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", verified_email='" + verifiedEmail + '\'' +
                ", name='" + name + '\'' +
                ", family_name='" + familyName + '\'' +
                ", given_name='" + givenName + '\'' +
                ", picture='" + picture + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }
}
