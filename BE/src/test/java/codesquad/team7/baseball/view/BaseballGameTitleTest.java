package codesquad.team7.baseball.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.assertj.core.api.Assertions.*;

@JsonTest
class BaseballGameTitleTest {

    @Autowired
    private ObjectMapper objectMapper;

    private final String GAME_ID = "\"gameId\"";
    private final String HOME = "\"home\"";
    private final String AWAY = "\"away\"";

    @Test
    @DisplayName("BaseballGameTitle을 json 형태로 구성한다.")
    void testJson() throws JsonProcessingException {
    }

    private String serialized(BaseballGameTitle gameTitle) {
        return "{" +
                GAME_ID +
                ":" +
                gameTitle.getGameId() +
                "," +
                HOME +
                ":\"" +
                gameTitle.getHome() +
                "\"," +
                AWAY +
                ":\"" +
                gameTitle.getAway() +
                "\"}";
    }

}
