package team9.baseball.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import team9.baseball.domain.enums.ResourceServer;

import java.util.HashMap;
import java.util.Map;

class JwtUtilTest {
    @Test
    @DisplayName("발급 및 인증 테스트")
    void createParseTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", 1l);
        map.put("userEmail", "isaac@naver.com");
        map.put("resourceServer", ResourceServer.GITHUB);
        String jwt = JwtUtil.createToken("access", "user", map, 10);
        Claims claims = JwtUtil.getTokenData(jwt);

        Assertions.assertThat(claims.get("userId", Integer.class)).isEqualTo(1);
        Assertions.assertThat(claims.get("userEmail", String.class)).isEqualTo("isaac@naver.com");
        Assertions.assertThat(claims.get("resourceServer", String.class)).isEqualTo("GITHUB");
    }

    @Test
    @DisplayName("서명 변조 테스트")
    void signatureTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", 1l);
        map.put("userEmail", "isaac@naver.com");
        map.put("resourceServer", "GITHUB");
        String jwt = JwtUtil.createToken("access", "user", map, 10);
        String wrongJwt = jwt.substring(0, jwt.length() - 1);

        checkWriteSignature(jwt, true);
        checkWriteSignature(wrongJwt, false);
    }

    void checkWriteSignature(String jwt, boolean validated) {
        boolean isWriteSignature = true;
        try {
            Claims claims = JwtUtil.getTokenData(jwt);
        } catch (SignatureException ex) {
            isWriteSignature = false;
        }
        Assertions.assertThat(isWriteSignature).isEqualTo(validated);
    }
}
