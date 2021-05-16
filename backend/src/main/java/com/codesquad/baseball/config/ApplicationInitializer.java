package com.codesquad.baseball.config;

import com.codesquad.baseball.service.DataInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements CommandLineRunner {

    private final DataInitializer dataInitializer;

    public ApplicationInitializer(DataInitializer dataInitializer) {
        this.dataInitializer = dataInitializer;
    }

    @Override
    public void run(String... args) throws Exception {
        dataInitializer.initialize();
    }
}
