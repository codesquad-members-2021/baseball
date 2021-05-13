package com.codesquad.baseball.exceptions.notfound;

public class UserNotFoundException extends NotFoundException {

    public static final String USER_NOT_FOUND = "찾으려는 유저정보를 찾지 못했습니다. userId : ";

    public UserNotFoundException(String id) {
        super(USER_NOT_FOUND + id);
    }
}
