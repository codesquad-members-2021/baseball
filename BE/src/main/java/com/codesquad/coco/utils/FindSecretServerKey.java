package com.codesquad.coco.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class FindSecretServerKey {

    public static SecretServerKey find() {
        try {
            InputStream inputStream = FindSecretServerKey.class.getResourceAsStream("/server.secret.json");
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(inputStream, SecretServerKey.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
