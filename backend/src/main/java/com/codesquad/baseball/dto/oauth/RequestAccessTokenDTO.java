package com.codesquad.baseball.dto.oauth;

public class RequestAccessTokenDTO {

    private static final String GRANT_TYPE = "authorization_code";

    private String client_id;
    private String client_secret;
    private String code;
    private String grant_type;
    private String redirect_uri;

    public RequestAccessTokenDTO() {
    }

    public RequestAccessTokenDTO(String client_id, String client_secret, String code, String redirect_uri) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.code = code;
        this.grant_type = GRANT_TYPE;
        this.redirect_uri = redirect_uri;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getCode() {
        return code;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }
}
