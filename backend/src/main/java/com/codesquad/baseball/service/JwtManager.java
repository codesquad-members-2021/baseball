package com.codesquad.baseball.service;

import com.codesquad.baseball.domain.user.User;
import com.codesquad.baseball.exceptions.oauth.InvalidJwtTokenException;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtManager {
    private static final String ISSUER = "sidedish";
    private static final long TOKEN_VALID_IME = 6 * 60 * 60 * 1000L;
    private final OAuthConfigManager oAuthConfigManager;

    public JwtManager(OAuthConfigManager oAuthConfigManager) {
        this.oAuthConfigManager = oAuthConfigManager;
    }

    public String createToken(User user) {
        Claims claims = Jwts.claims();
        claims.put("userId", user.getUserId());
        Date now = new Date();
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, oAuthConfigManager.serverSecret())
                .setClaims(claims)
                .setIssuer(ISSUER)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + TOKEN_VALID_IME))
                .compact();
    }

    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(oAuthConfigManager.serverSecret()).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
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
