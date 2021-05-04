package com.baseball.dto;

public class LoginRequest {

    private final String id;
    private final String pw;

    public LoginRequest(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
}
