package com.codesquad.baseball.service;

import com.codesquad.baseball.domain.user.User;
import com.codesquad.baseball.domain.user.UserRepository;
import com.codesquad.baseball.dto.oauth.UserInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final JwtManager jwtManager;

    public UserService(UserRepository userRepository, JwtManager jwtManager) {
        this.userRepository = userRepository;
        this.jwtManager = jwtManager;
    }

    public User login(UserInfoDTO userInfoDTO) {
        Optional<User> optionalUser = findUserByUserId(userInfoDTO.getId());
        User user = userLoginCheck(userInfoDTO, optionalUser);
        String jwtToken = jwtManager.createToken(user);
        logger.info("jwtToken : {}", jwtToken);
        user.updateToken(jwtToken);
        userRepository.save(user);
        return user;
    }

    private User userLoginCheck(UserInfoDTO userInfoDTO, Optional<User> optionalUser) {
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.update(userInfoDTO);
            return userRepository.save(user);
        }
        return createUser(userInfoDTO);
    }

    public User createUser(UserInfoDTO userInfoDTO) {
        return userRepository.save(new User(userInfoDTO));
    }

    public Optional<User> findUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}
