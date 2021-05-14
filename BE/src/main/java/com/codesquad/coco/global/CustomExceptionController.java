package com.codesquad.coco.global;


import com.gitoauth.coco.JWT.OverTimeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionController {

    @ExceptionHandler(OverTimeException.class)
    public void OverTime(OverTimeException e) {
        // todo : 시간 만료
    }
}
