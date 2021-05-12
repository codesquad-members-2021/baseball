package codesquad.team7.baseball.controller;

import codesquad.team7.baseball.config.RestDocsMockMvcConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Import(RestDocsMockMvcConfiguration.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriHost = "ec2-3-35-10-144.ap-northeast-2.compute.amazonaws.com", uriPort = 80)
class BaseballControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("게임 리스트를 가져온다.")
    void getGames() throws Exception {
        FieldDescriptor[] gameTitle = new FieldDescriptor[]{
                fieldWithPath("gameId").description("게임의 id"),
                fieldWithPath("home").description("홈팀의 이름"),
                fieldWithPath("away").description("어웨이팀의 이름")
        };

        mockMvc.perform(get("/games"))
                .andExpect(status().isOk())
                .andDo(document(
                        "games",
                        responseFields(fieldWithPath("games").description("게임의 목록"))
                                .andWithPrefix("games.[]", gameTitle)
                ));
    }


    @Test
    @DisplayName("게임을 가져온다.")
    void baseballGame() throws Exception {
        FieldDescriptor[] team = new FieldDescriptor[]{
                fieldWithPath("name").description("팀 이름"),
                fieldWithPath("score").description("현재 팀 점수"),
                fieldWithPath("players").description("팀 선수 목록"),
                fieldWithPath("pitcher").description("팀 투수 정보")
        };

        FieldDescriptor[] player = new FieldDescriptor[]{
                fieldWithPath("name").description("선수 이름"),
                fieldWithPath("atBat").description("타석"),
                fieldWithPath("hits").description("안타"),
                fieldWithPath("out").description("아웃"),
                fieldWithPath("average").description("평균")
        };

        FieldDescriptor[] pitcher = new FieldDescriptor[]{
                fieldWithPath("number").description("투수 번호"),
                fieldWithPath("pitches").description("투구 수")
        };

        mockMvc.perform(get("/games/3"))
                .andExpect(status().isOk())
                .andDo(document("game",
                        responseFields(
                                fieldWithPath("game").description("야구 게임"),
                                fieldWithPath("game.home").description("홈 팀"),
                                fieldWithPath("game.away").description("어웨이 팀"),
                                fieldWithPath("game.inning").description("현재 이닝"),
                                fieldWithPath("game.state").description("공격팀"),
                                fieldWithPath("game.batter").description("타자 번호"),
                                fieldWithPath("game.strike").description("스트라이크"),
                                fieldWithPath("game.ball").description("볼"),
                                fieldWithPath("game.out").description("아웃"),
                                fieldWithPath("game.history").description("현재 타자 기록"),
                                fieldWithPath("game.baseState").description("진루 상황, 1루, 2루, 3루, 홈"),
                                fieldWithPath("game.inningScore").description("이닝 별 득점"),
                                fieldWithPath("game.inningScore.home").description("홈 팀의 이닝별 득점"),
                                fieldWithPath("game.inningScore.away").description("어웨이 팀의 이닝별 득점")
                        )
                                .andWithPrefix("game.home.", team)
                                .andWithPrefix("game.away.", team)
                                .andWithPrefix("game.home.players.[]", player)
                                .andWithPrefix("game.away.players.[]", player)
                                .andWithPrefix("game.home.pitcher.", pitcher)
                                .andWithPrefix("game.away.pitcher.", pitcher)
                ));
    }
}
