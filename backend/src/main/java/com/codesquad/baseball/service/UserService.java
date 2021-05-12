package com.codesquad.baseball.service;

import com.codesquad.baseball.domain.user.User;
import com.codesquad.baseball.domain.user.UserRepository;
import com.codesquad.baseball.dto.oauth.JwtTokenDTO;
import com.codesquad.baseball.dto.oauth.UserInfoDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtManager jwtManager;

    public UserService(UserRepository userRepository, JwtManager jwtManager) {
        this.userRepository = userRepository;
        this.jwtManager = jwtManager;
    }

    public JwtTokenDTO login(UserInfoDTO userInfoDTO) {
        Optional<User> optionalUser = findUserByUserId(userInfoDTO.getId());
        JwtTokenDTO jwtTokenDTO = jwtManager.createToken(userInfoDTO.getId());
        processUserData(userInfoDTO, optionalUser, jwtTokenDTO);
        return jwtTokenDTO;
    }

    private void processUserData(UserInfoDTO userInfoDTO, Optional<User> optionalUser, JwtTokenDTO jwtTokenDTO) {
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.update(userInfoDTO);
            userRepository.save(user);
        }
        createUser(userInfoDTO, jwtTokenDTO);
    }

    public User createUser(UserInfoDTO userInfoDTO, JwtTokenDTO jwtTokenDTO) {
        return userRepository.save(new User(userInfoDTO, jwtTokenDTO));
    }

    public Optional<User> findUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}
