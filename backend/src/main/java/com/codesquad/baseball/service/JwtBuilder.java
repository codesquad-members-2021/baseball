package com.codesquad.baseball.service;

import com.codesquad.baseball.dto.oauth.AccessTokenDTO;
import com.codesquad.baseball.dto.oauth.JwtTokenDTO;
import com.codesquad.baseball.exceptions.oauth.InvalidJwtTokenException;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtBuilder {
    private static final String ISSUER = "baseball";
    private static final String USER_ID = "USER_ID";
    private static final long ACCESS_TOKEN_EXPIRATION = 60 * 60 * 1000L;
    private static final long REFERSH_TOKEN_EXPIRATION = 7 * 24 * 60 * 60 * 1000L;
    private final OAuthConfigManager oAuthConfigManager;

    public JwtBuilder(OAuthConfigManager oAuthConfigManager) {
        this.oAuthConfigManager = oAuthConfigManager;
    }

    public JwtTokenDTO createToken(String id) {
        Date now = new Date();
        String accessToken = buildAccessToken(now, id);
        String refreshToken = buildRefreshToken(now, id);
        return new JwtTokenDTO.Builder()
                .userId(id)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpirationDate(new Date(now.getTime() + ACCESS_TOKEN_EXPIRATION))
                .refreshTokenExpirationDate(new Date(now.getTime() + REFERSH_TOKEN_EXPIRATION))
                .build();
    }

    private String buildAccessToken(Date now, String id) {
        Claims claims = Jwts.claims();
        claims.put(USER_ID, id);
        return buildToken(now, id, ACCESS_TOKEN_EXPIRATION);
    }

    private String buildRefreshToken(Date now, String id) {
        Claims claims = Jwts.claims();
        claims.put(USER_ID, id);
        return buildToken(now, id, REFERSH_TOKEN_EXPIRATION);
    }

    private String buildToken(Date now, String id, Long expirationTime) {
        Claims claims = Jwts.claims();
        claims.put(USER_ID, id);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, oAuthConfigManager.serverSecret())
                .setClaims(claims)
                .setIssuer(ISSUER)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expirationTime))
                .compact();
    }
}
