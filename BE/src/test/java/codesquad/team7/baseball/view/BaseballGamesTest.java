package codesquad.team7.baseball.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.assertj.core.api.Assertions.*;

@JsonTest
class BaseballGamesTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("BaseballGame을 json 형태로 구성한다.")
    void serializeToJson() throws JsonProcessingException {
    }

}
