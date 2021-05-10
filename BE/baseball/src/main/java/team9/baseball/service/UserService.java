package team9.baseball.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team9.baseball.domain.aggregate.user.User;
import team9.baseball.domain.enums.ResourceServer;
import team9.baseball.exception.NotFoundException;
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
