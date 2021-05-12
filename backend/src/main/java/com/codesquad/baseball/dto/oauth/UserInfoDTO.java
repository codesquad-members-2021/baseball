package com.codesquad.baseball.dto.oauth;

public class UserInfoDTO {
    private String id;
    private String email;
    private String verified_email;
    private String name;
    private String family_name;
    private String given_name;
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

    public String getVerified_email() {
        return verified_email;
    }

    public String getName() {
        return name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public String getGiven_name() {
        return given_name;
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
                ", verified_email='" + verified_email + '\'' +
                ", name='" + name + '\'' +
                ", family_name='" + family_name + '\'' +
                ", given_name='" + given_name + '\'' +
                ", picture='" + picture + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }
}
