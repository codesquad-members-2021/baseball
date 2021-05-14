package com.codesquad.coco.utils;

public enum GitURI {

    REDIRECT_URI("http://ec2-52-78-180-217.ap-northeast-2.compute.amazonaws.com/login/github"),
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
