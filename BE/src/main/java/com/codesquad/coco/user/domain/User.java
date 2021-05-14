package com.codesquad.coco.user.domain;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private Long id;

    private Long githubId;
    private String login;
    private String htmlUrl;
    private String location;
    private int followers;
    private int following;
    private String accessToken;
    private String refreshToken;

    private User(Long githubId, String login, String htmlUrl, String location,
                 int followers, int following, String accessToken, String refreshToken) {
        this.id = id;
        this.githubId = githubId;
        this.login = login;
        this.htmlUrl = htmlUrl;
        this.location = location;
        this.followers = followers;
        this.following = following;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public Long getId() {
        return id;
    }

    public Long getGithubId() {
        return githubId;
    }

    public String getLogin() {
        return login;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getLocation() {
        return location;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public static class Builder {
        private Long id;
        private Long githubId;
        private String login;
        private String htmlUrl;
        private String location;
        private int followers;
        private int following;
        private String accessToken;
        private String refreshToken;

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder githubId(Long val) {
            githubId = val;
            return this;
        }

        public Builder login(String val) {
            login = val;
            return this;
        }

        public Builder htmlUrl(String val) {
            htmlUrl = val;
            return this;
        }

        public Builder location(String val) {
            location = val;
            return this;
        }

        public Builder followers(int val) {
            followers = val;
            return this;
        }

        public Builder following(int val) {
            following = val;
            return this;
        }

        public Builder accessToken(String val) {
            accessToken = val;
            return this;
        }

        public Builder refreshToken(String val) {
            refreshToken = val;
            return this;
        }

        public User builder() {
            return new User(githubId, login, htmlUrl, location, followers, following, accessToken, refreshToken);
        }

    }
}
