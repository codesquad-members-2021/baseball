package team9.baseball.service;

import org.springframework.stereotype.Service;

@Service
public interface OauthService {
    String getAccessToken(String authorizationCode);

    String getEmail(String accessToken);
}
