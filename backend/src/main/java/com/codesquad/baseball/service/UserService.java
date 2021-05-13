package com.codesquad.baseball.service;

import com.codesquad.baseball.domain.user.User;
import com.codesquad.baseball.domain.user.UserRepository;
import com.codesquad.baseball.dto.oauth.JwtTokenDTO;
import com.codesquad.baseball.dto.oauth.UserInfoDTO;
import com.codesquad.baseball.exceptions.notfound.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtBuilder jwtBuilder;

    public UserService(UserRepository userRepository, JwtBuilder jwtBuilder) {
        this.userRepository = userRepository;
        this.jwtBuilder = jwtBuilder;
    }

    public JwtTokenDTO login(UserInfoDTO userInfoDTO) {
        Optional<User> optionalUser = findOptionalUserByUserId(userInfoDTO.getId());
        JwtTokenDTO jwtTokenDTO = jwtBuilder.createToken(userInfoDTO.getId());
        processUserData(userInfoDTO, optionalUser, jwtTokenDTO);
        return jwtTokenDTO;
    }

    @Transactional
    public JwtTokenDTO refreshToken(String userId) {
        User user = findUserByUserId(userId);
        JwtTokenDTO newTokenDTO = jwtBuilder.createToken(userId);
        user.updateAccessToken(newTokenDTO.getAccessToken());
        user.updateRefreshToken(newTokenDTO.getRefreshToken());
        userRepository.save(user);
        return newTokenDTO;
    }

    private void processUserData(UserInfoDTO userInfoDTO, Optional<User> optionalUser, JwtTokenDTO jwtTokenDTO) {
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.update(userInfoDTO);
            user.updateAccessToken(jwtTokenDTO.getAccessToken());
            user.updateRefreshToken(jwtTokenDTO.getRefreshToken());
            userRepository.save(user);
            return;
        }
        createUser(userInfoDTO, jwtTokenDTO);
    }

    public User createUser(UserInfoDTO userInfoDTO, JwtTokenDTO jwtTokenDTO) {
        return userRepository.save(new User(userInfoDTO, jwtTokenDTO));
    }

    public Optional<User> findOptionalUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    public User findUserByUserId(String userId) {
        return userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }
}
