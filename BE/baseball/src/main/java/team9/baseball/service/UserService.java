package team9.baseball.service;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team9.baseball.domain.aggregate.user.User;
import team9.baseball.domain.enums.ResourceServer;
import team9.baseball.exception.NotFoundException;
import team9.baseball.exception.UnauthorizedException;
import team9.baseball.repository.UserRepository;
import team9.baseball.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final String JWT_SIGN_IN_SUBJECT = "sign_in";
    private static final String JWT_ID = "id";
    private static final String JWT_EMAIL = "email";
    private static final String JWT_RESOURCE_SERVER = "resource_server";

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String signIn(String email, ResourceServer resourceServer) {
        //회원 정보가 없으면 자동 회원가입
        if (!userRepository.existsByEmail(email)) {
            signUp(email, resourceServer);
        }

        User user = getUser(email);
        return getJsonWebToken(user);
    }

    public Long getUserIdFromJwt(String jwt) {
        Claims claims = JwtUtil.getTokenData(jwt);
        System.out.println(claims.getSubject());
        if (!JWT_SIGN_IN_SUBJECT.equals(claims.getSubject())) {
            throw new UnauthorizedException("토큰의 주제가 로그인 확인과 다릅니다.");
        }
        Long id = claims.get(JWT_ID, Long.class);
        String email = claims.get(JWT_EMAIL, String.class);
        String resourceServer = claims.get(JWT_RESOURCE_SERVER, String.class);

        User user = userRepository.findByIdAndEmailAndOauthResourceServer(id, email, resourceServer)
                .orElseThrow(() -> new UnauthorizedException("토큰 정보에 해당하는 사용자를 찾을 수 없습니다."));

        return user.getId();
    }

    private String getJsonWebToken(User user) {
        Map<String, Object> privateClaims = new HashMap<>();
        privateClaims.put(JWT_ID, user.getId());
        privateClaims.put(JWT_EMAIL, user.getEmail());
        privateClaims.put(JWT_RESOURCE_SERVER, user.getOauthResourceServer());

        return JwtUtil.createToken(JWT_SIGN_IN_SUBJECT, "User", privateClaims, 100);
    }

    private void signUp(String email, ResourceServer resourceServer) {
        User user = new User(email, resourceServer);
        userRepository.save(user);
    }

    private User getUser(String email) {
        return userRepository.findByEmail(email).
                orElseThrow(() -> new NotFoundException("해당 email의 사용자는 존재하지 않습니다."));
    }
}
