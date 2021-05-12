package codesquad.team7.baseball.auth;

import com.fasterxml.jackson.annotation.JsonSetter;

public class GithubAccessTokenResponse {

    private String accessToken;
    private String tokenType;
    private String scope;

    public GithubAccessTokenResponse() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    @JsonSetter("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    @JsonSetter("token_type")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getScope() {
        return scope;
    }

    @JsonSetter("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }
}
