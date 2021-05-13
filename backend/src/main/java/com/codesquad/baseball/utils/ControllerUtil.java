package com.codesquad.baseball.utils;

import com.codesquad.baseball.config.AuthInterceptor;
import com.codesquad.baseball.exceptions.oauth.ExtractUserIdFromTokenFailedException;

import javax.servlet.http.HttpServletRequest;

public class ControllerUtil {

    private ControllerUtil() {
    }

    public static String extractUserIdFromRequest(HttpServletRequest request) {
        String userId = (String) request.getAttribute(AuthInterceptor.USER_ID_KEY);
        if (userId == null || userId.isEmpty()) {
            throw new ExtractUserIdFromTokenFailedException(ExtractUserIdFromTokenFailedException.EXTRACTION_FAILED);
        }
        return userId;
    }
}
