package com.codesquad.baseball.service;

import com.codesquad.baseball.domain.user.User;
import com.codesquad.baseball.dto.oauth.AccessTokenDTO;
import com.codesquad.baseball.dto.oauth.RefreshTokenDTO;
import com.codesquad.baseball.exceptions.oauth.InvalidJwtTokenException;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

@Service
public class JwtVerifier {
    private static final String ISSUER = "baseball";
    private static final String USER_ID = "USER_ID";

    private final OAuthConfigManager oAuthConfigManager;
    private final UserService userService;

    public JwtVerifier(OAuthConfigManager oAuthConfigManager, UserService userService) {
        this.oAuthConfigManager = oAuthConfigManager;
        this.userService = userService;
    }

    public String extractUserIdFromJwt(String jwt) {
        Jws<Claims> claims = verifyJwt(jwt);
        return (String) claims.getBody().get(USER_ID);
    }

    public void verifyAccessToken(AccessTokenDTO accessTokenDTO) {
        String userId = accessTokenDTO.getUserId();
        User user = userService.findUserByUserId(userId);
        user.verifyAccessToken(accessTokenDTO.getAccessToken());
    }

    public void verifyRefreshToken(RefreshTokenDTO refreshTokenDTO) {
        String userId = refreshTokenDTO.getUserId();
        User user = userService.findUserByUserId(userId);
        user.verifyRefreshToken(refreshTokenDTO.getRefreshToken());
    }

    private Jws<Claims> verifyJwt(String jwt) {
        try {
            return Jwts.parser().setSigningKey(oAuthConfigManager.serverSecret()).parseClaimsJws(jwt);
        } catch (ExpiredJwtException e) {
            throw new InvalidJwtTokenException(InvalidJwtTokenException.EXPIRED_JWT_EXCEPTION);
        } catch (UnsupportedJwtException e) {
            throw new InvalidJwtTokenException(InvalidJwtTokenException.UNSUPPORTED_JWT_EXCEPTION);
        } catch (MalformedJwtException e) {
            throw new InvalidJwtTokenException(InvalidJwtTokenException.MALFORMED_JWT_EXCEPTION);
        } catch (SignatureException e) {
            throw new InvalidJwtTokenException(InvalidJwtTokenException.SIGNATURE_EXCEPTION);
        } catch (IllegalArgumentException e) {
            throw new InvalidJwtTokenException(InvalidJwtTokenException.ILLEGAL_ARGUMENT_EXCEPTION);
        }
    }
}
