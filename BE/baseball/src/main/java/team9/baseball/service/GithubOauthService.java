package team9.baseball.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import team9.baseball.DTO.response.github.GithubEmailDTO;
import team9.baseball.DTO.response.github.GithubTokenDTO;
import team9.baseball.exception.OauthException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GithubOauthService implements OauthService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String clientId = "6c8240ec73fc69e81d92";       //배포시에는 환경변수로 설정
    private final String clientSecret = "84f7e4fd4b00260fa6ce8a5f66ac04a96c1d8df9";   //배포시에는 환경변수로 설정

    //https://github.com/login/oauth/authorize?client_id=6c8240ec73fc69e81d92&scope=user:email
    @Override
    public String getAccessToken(String authorizationCode) {
        String url = "https://github.com/login/oauth/access_token";
        logger.debug("authorization code: " + authorizationCode);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        Map<String, String> header = new HashMap<>();
        header.put("Accept", "application/json"); //json 형식으로 응답 받음
        headers.setAll(header);

        MultiValueMap<String, String> requestPayloads = new LinkedMultiValueMap<>();
        Map<String, String> requestPayload = new HashMap<>();
        requestPayload.put("client_id", clientId);
        requestPayload.put("client_secret", clientSecret);
        requestPayload.put("code", authorizationCode);
        requestPayloads.setAll(requestPayload);

        HttpEntity request = new HttpEntity<>(requestPayloads, headers);
        ResponseEntity<GithubTokenDTO> response = new RestTemplate().postForEntity(url, request, GithubTokenDTO.class); //미리 정의해둔 GithubToken 클래스 형태로 Response Body를 파싱해서 담아서 리턴
        String accessToken = response.getBody().getAuthorizationValue();

        if (accessToken == null) {
            throw new OauthException("잘못된 github Authorization code 입니다.");
        }

        return response.getBody().getAuthorizationValue();
    }

    @Override
    public String getEmail(String accessToken) {
        String url = "https://api.github.com/user/emails";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        Map<String, String> header = new HashMap<>();
        header.put("Accept", "application/json"); //json 형식으로 응답 받음
        header.put("Authorization", accessToken);
        headers.setAll(header);

        HttpEntity<?> request = new HttpEntity<>(headers);
        ResponseEntity<String> response;
        try {
            response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class);
        } catch (HttpClientErrorException ex) {
            throw new OauthException("유효한 github access token 이 아닙니다.");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        List<GithubEmailDTO> emails = null;
        try {
            emails = objectMapper.readValue(response.getBody(), new TypeReference<List<GithubEmailDTO>>() {
            });
        } catch (IOException ex) {
            throw new OauthException("github email 정보를 가져올 수 없습니다.");
        }

        if (emails == null || emails.isEmpty()) {
            throw new OauthException("github email 정보를 가져올 수 없습니다.");
        }
        return emails.get(0).getEmail();
    }
}
