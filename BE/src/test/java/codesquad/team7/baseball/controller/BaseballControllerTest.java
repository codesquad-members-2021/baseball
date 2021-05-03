package codesquad.team7.baseball.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

@WebMvcTest(BaseballController.class)
@AutoConfigureRestDocs
class BaseballControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("게임 리스트를 가져온다.")
    void getGames() throws Exception {
        FieldDescriptor[] game = new FieldDescriptor[] {
                fieldWithPath("gameId").description("게임의 id"),
                fieldWithPath("home").description("홈팀의 이름"),
                fieldWithPath("away").description("어웨이팀의 이름")
        };

        mockMvc.perform(get("/games"))
                .andExpect(jsonPath("$.games").isArray())
                .andDo(document("baseball",
                        responseFields(
                                fieldWithPath("games").description("게임의 목록")
                        ).andWithPrefix("games.[]", game)));
    }

}
