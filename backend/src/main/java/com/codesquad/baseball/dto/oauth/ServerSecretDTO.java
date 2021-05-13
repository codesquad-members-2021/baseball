package com.codesquad.baseball.dto.oauth;

public class ServerSecretDTO {
    private String clientId;
    private String clientSecret;
    private String serverSecret;

    public ServerSecretDTO() {
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getServerSecret() {
        return serverSecret;
    }
}
