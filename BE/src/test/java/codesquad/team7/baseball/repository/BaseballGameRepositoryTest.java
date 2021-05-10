package codesquad.team7.baseball.repository;

import codesquad.team7.baseball.game.BaseballGame;
import codesquad.team7.baseball.team.Player;
import codesquad.team7.baseball.team.Team;
import codesquad.team7.baseball.team.TeamRepository;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BaseballGameRepositoryTest {

    private SoftAssertions softly;

    private BaseballGame baseballGame;
    private Team dinos;
    private Team eagles;

    @Autowired
    private BaseballGameRepository baseballGameRepository;

    @Autowired
    private TeamRepository teamRepository;

    @BeforeEach
    void setUp() {
        softly = new SoftAssertions();
    }

    @AfterEach
    void afterEach() {
        softly.assertAll();
    }

    @Test
    @DisplayName("디비에 게임을 저장하고, 가져온다.")
    void saveBaseballGameAndGet() {
        dinos = Team.newTeam("NC Dinos", 0);
        dinos.addPlayer(new Player("김준완"));
        dinos.addPlayer(new Player("박민우"));
        dinos.addPlayer(new Player("김철호"));
        dinos.addPlayer(new Player("최보성"));
        dinos.addPlayer(new Player("김민수"));
        dinos.addPlayer(new Player("김찬형"));
        dinos.addPlayer(new Player("김주원"));
        dinos.addPlayer(new Player("김기환"));
        dinos.addPlayer(new Player("최승민"));

        eagles = Team.newTeam("Eagles", 2);
        eagles.addPlayer(new Player("조현진"));
        eagles.addPlayer(new Player("노태형"));
        eagles.addPlayer(new Player("강재민"));
        eagles.addPlayer(new Player("조한민"));
        eagles.addPlayer(new Player("김현민"));
        eagles.addPlayer(new Player("오선진"));
        eagles.addPlayer(new Player("강경학"));
        eagles.addPlayer(new Player("노시환"));
        eagles.addPlayer(new Player("박정현"));

        eagles = teamRepository.save(eagles);
        dinos = teamRepository.save(dinos);

        baseballGame = BaseballGame.newGame(dinos, eagles);

        baseballGame = baseballGameRepository.save(baseballGame);
        softly.assertThat(baseballGame.getId()).isNotEqualTo(0L);

        BaseballGame loadedBaseballGame = baseballGameRepository.findById(baseballGame.getId()).get();
        softly.assertThat(loadedBaseballGame.getId()).isEqualTo(baseballGame.getId());
    }
}
