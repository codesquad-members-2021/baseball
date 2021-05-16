package com.codesquad.baseball.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* Auth 애노테이션은 컨트롤러 메서드에 붙이는 애노테이션입니다
* Auth 어노테이션이 달려있으면 인터셉터에서 액세스 토큰을 검사합니다
* */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
}
