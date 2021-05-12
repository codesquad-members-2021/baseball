package com.codesquad.coco.utils;

public enum GitURI {

    REDIRECT_URI("http://localhost:8080/login/github"),
    ACCESS_TOKEN_URI("https://github.com/login/oauth/access_token"),
    AUTHORIZE_URI("https://github.com/login/oauth/authorize"),
    USER_INFO_URI("https://api.github.com/user");

    private String uri;

    GitURI(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
