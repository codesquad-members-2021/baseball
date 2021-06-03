package com.baseball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {
    @GetMapping
    public String getDocs() {
        return "redirect:/swagger-ui.html";
    }
}
