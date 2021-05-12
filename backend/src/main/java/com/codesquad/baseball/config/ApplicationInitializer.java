package com.codesquad.baseball.config;

import com.codesquad.baseball.service.DataInitializer;
import com.codesquad.baseball.service.OAuthConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

    private final DataInitializer dataInitializer;
    private final OAuthConfigManager oAuthConfigManager;

    public ApplicationInitializer(DataInitializer dataInitializer, OAuthConfigManager oAuthConfigManager) {
        this.dataInitializer = dataInitializer;
        this.oAuthConfigManager = oAuthConfigManager;
    }

    @Override
    public void run(String... args) throws Exception {
        dataInitializer.initialize();
    }
}
