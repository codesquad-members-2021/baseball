package com.codesquad.baseball.utils;

import com.codesquad.baseball.exceptions.oauth.InvalidJwtTokenException;
import com.codesquad.baseball.exceptions.oauth.NoJwtTokenException;

import javax.servlet.http.HttpServletRequest;

public class TokenUtil {

    private static final int BEARER_TOKEN_LENGTH = 2;
    private static final int TOKEN = 1;

    private TokenUtil() {
    }

    public static String extractTokenFromHeader(HttpServletRequest request) {
        String authorizationValue = request.getHeader("Authorization");
        if (authorizationValue == null || authorizationValue.isEmpty()) {
            throw new NoJwtTokenException(NoJwtTokenException.NO_TOKEN_IN_REQUEST_HEADER);
        }
        String[] splitedString = authorizationValue.split(" ");
        if (splitedString.length != BEARER_TOKEN_LENGTH) {
            throw new InvalidJwtTokenException(InvalidJwtTokenException.BAD_TOKEN);
        }
        return splitedString[TOKEN];
    }
}
