package com.codesquad.baseball.utils;

import com.codesquad.baseball.service.DataInitializer;
import com.codesquad.baseball.service.OAuthManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

    private final DataInitializer dataInitializer;
    private final OAuthManager oAuthManager;

    public ApplicationInitializer(DataInitializer dataInitializer, OAuthManager oAuthManager) {
        this.dataInitializer = dataInitializer;
        this.oAuthManager = oAuthManager;
    }

    @Override
    public void run(String... args) throws Exception {
        dataInitializer.initialize();
    }
}
