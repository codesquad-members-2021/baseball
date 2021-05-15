package team9.baseball.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final String SECRET_KEY = System.getenv("JWT_SECRET_KEY");

    public static String createToken(String subject, String audience, Map<String, Object> privateClaims, int expiredMinute) {

        long ttlMillis = (expiredMinute * 60 * 1000);

        if (ttlMillis <= 0) {
            throw new RuntimeException("JWT 유효시간은 0보다 작거나 같을 수 없습니다.");
        }

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setIssuer("isaac.baseball.api")
                .setAudience(audience)
                .setHeaderParam("type", "JWT")
                .signWith(signatureAlgorithm, signingKey);

        for (Map.Entry<String, Object> claim : privateClaims.entrySet()) {
            builder.claim(claim.getKey(), claim.getValue());
        }


        long nowMillis = System.currentTimeMillis();
        builder.setExpiration(new Date(nowMillis + ttlMillis));
        return builder.compact();
    }

    public static Claims getTokenData(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(token).getBody();

        return claims;
    }
}
