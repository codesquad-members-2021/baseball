package com.codesquad.baseball.dto.oauth;

public class AuthorizationInfo {

    private String code;
    private String scope;
    private String authuser;
    private String prompt;

    public AuthorizationInfo(String code, String scope, String authuser, String prompt) {
        this.code = code;
        this.scope = scope;
        this.authuser = authuser;
        this.prompt = prompt;
    }

    public String getCode() {
        return code;
    }

    public String getScope() {
        return scope;
    }

    public String getAuthuser() {
        return authuser;
    }

    public String getPrompt() {
        return prompt;
    }

}

