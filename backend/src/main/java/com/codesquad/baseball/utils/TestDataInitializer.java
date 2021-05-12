package com.codesquad.baseball.utils;

import com.codesquad.baseball.service.Initializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitializer implements CommandLineRunner {

    private final Initializer initializer;

    public TestDataInitializer(Initializer initializer) {
        this.initializer = initializer;
    }

    @Override
    public void run(String... args) throws Exception {
        initializer.initialize();
    }
}
