package com.baseball.controller;

import com.baseball.exception.MatchNotFoundException;
import com.baseball.exception.MatchOccupiedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    private final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(MatchNotFoundException.class)
    public ResponseEntity handleMatchNotFound(MatchNotFoundException e) {
        logger.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("존재하지 않는 Match 입니다.");
    }

    @ExceptionHandler(MatchOccupiedException.class)
    public ResponseEntity handleMatchOccupied(MatchOccupiedException e) {
        logger.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
