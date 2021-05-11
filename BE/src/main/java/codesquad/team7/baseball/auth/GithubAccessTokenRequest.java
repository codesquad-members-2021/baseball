package codesquad.team7.baseball.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubAccessTokenRequest {

    private String clientId;
    private String clientSecret;
    private String code;

    public GithubAccessTokenRequest() {
    }

    public GithubAccessTokenRequest(String clientId, String clientSecret, String code) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.code = code;
    }

    @JsonProperty("client_id")
    public String getClientId() {
        return clientId;
    }

    @JsonProperty("client_secret")
    public String getClientSecret() {
        return clientSecret;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }
}

