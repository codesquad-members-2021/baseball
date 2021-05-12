package com.codesquad.baseball.service;

import com.codesquad.baseball.dto.oauth.ServerSecretDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class OAuthConfigManager {

    private static final Logger logger = LoggerFactory.getLogger(OAuthConfigManager.class);
    private static final String LOADING_OAUTH_CONFIG_FAILED_ERROR_MESSAGE = "OAuth 설정파일을 읽는 과정에서 문제가 발생했습니다. 프로그램을 종료합니다";
    private static final String LOADING_OAUTH_CONFIG_COMPLETE = "loading oauth config complete!";
    private final ServerSecretDTO serverSecretDTO;

    public OAuthConfigManager() {
        serverSecretDTO = loadOAuthConfig();
    }

    public ServerSecretDTO loadOAuthConfig() {
        ServerSecretDTO serverSecretDTO = null;
        try {
            InputStream inputStream = OAuthConfigManager.class.getResourceAsStream("/server.secret.json");
            ObjectMapper objectMapper = new ObjectMapper();
            serverSecretDTO = objectMapper.readValue(inputStream, ServerSecretDTO.class);

        } catch (IOException e) {
            logger.error(LOADING_OAUTH_CONFIG_FAILED_ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
        logger.info(LOADING_OAUTH_CONFIG_COMPLETE);
        return serverSecretDTO;
    }

    public String clientId() {
        return serverSecretDTO.getClientId();
    }

    public String clientSecret() {
        return serverSecretDTO.getClientSecret();
    }

    public String serverSecret() {
        return serverSecretDTO.getServerSecret();
    }
}
