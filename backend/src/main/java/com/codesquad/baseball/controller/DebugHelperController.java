package com.codesquad.baseball.controller;

import com.codesquad.baseball.service.DataInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reset")
public class DebugHelperController {

    private final DataInitializer dataInitializer;

    public DebugHelperController(DataInitializer dataInitializer) {
        this.dataInitializer = dataInitializer;
    }

    @CrossOrigin
    @PatchMapping
    public void reset() {
        dataInitializer.reset();
    }

}
