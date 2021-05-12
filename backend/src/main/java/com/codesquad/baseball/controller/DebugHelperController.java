package com.codesquad.baseball.controller;

import com.codesquad.baseball.service.Initializer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reset")
public class DebugHelperController {

    private final Initializer initializer;

    public DebugHelperController(Initializer initializer) {
        this.initializer = initializer;
    }

    @CrossOrigin
    @PatchMapping
    public void reset() {
        initializer.reset();
    }

}
