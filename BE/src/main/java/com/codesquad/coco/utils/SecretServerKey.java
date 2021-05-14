package com.codesquad.coco.utils;

import java.nio.charset.StandardCharsets;

public class SecretServerKey {

    private String clientId;
    private String clientSecret;
    private String serverSecret;

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getServerSecret() {
        return serverSecret;
    }

    public byte[] serverSecretToByteArray() {
        return serverSecret.getBytes(StandardCharsets.UTF_8);
    }
}
