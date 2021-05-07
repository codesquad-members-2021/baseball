package codesquad.team7.baseball.config;

import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentationConfigurer;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

@TestConfiguration
public class RestDocsMockMvcConfiguration implements RestDocsMockMvcConfigurationCustomizer {

    @Override
    public void customize(MockMvcRestDocumentationConfigurer configurer) {
        configurer.operationPreprocessors()
                .withResponseDefaults(prettyPrint())
                .and()
                .uris()
                .withScheme("http")
                .withHost("ec2-3-35-10-144.ap-northeast-2.compute.amazonaws.com")
                .withPort(80);
    }
}
