package com.baseball.controller;

import com.baseball.dto.LoginRequest;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Auth API"}, description = "로그인과 사용자 인증과 관련된 API")
@RestController
public class AuthController {
    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/api/login")
    public ResponseEntity<String> postLogin(@RequestBody LoginRequest loginRequest) {
        logger.debug("{} {}", loginRequest.getId(), loginRequest.getPw());
        if (loginRequest.getId().equals("pyro") && loginRequest.getPw().equals("robin")) {
            return ResponseEntity.ok().body("Login Success!");
        }
        return new ResponseEntity<>("Unauthroized", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/api/ping")
    public ResponseEntity<String> getPing() {
        return ResponseEntity.ok().body("pong");
    }
}
