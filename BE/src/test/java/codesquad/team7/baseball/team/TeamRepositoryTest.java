package codesquad.team7.baseball.team;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    private SoftAssertions softly;

    @BeforeEach
    void setUp() {
        softly = new SoftAssertions();
    }

    @AfterEach
    void afterEach() {
        softly.assertAll();
    }

    @Test
    @DisplayName("새로운 팀을 생성하여 저장한다.")
    void newTeam() {
        String teamName = "NC Dinos";
        Integer pitcherNumber = 0;
        Integer playerSize = 9;
        Team dinos = Team.newTeam(teamName, pitcherNumber);
        dinos.addPlayer(new Player("김준완"));
        dinos.addPlayer(new Player("박민우"));
        dinos.addPlayer(new Player("김철호"));
        dinos.addPlayer(new Player("최보성"));
        dinos.addPlayer(new Player("김민수"));
        dinos.addPlayer(new Player("김찬형"));
        dinos.addPlayer(new Player("김주원"));
        dinos.addPlayer(new Player("김기환"));
        dinos.addPlayer(new Player("최승민"));

        Team savedTeam = teamRepository.save(dinos);
        Team foundTeam = teamRepository.findById(savedTeam.getId()).get();

        softly.assertThat(foundTeam)
                .hasFieldOrPropertyWithValue("id", savedTeam.getId())
                .hasFieldOrPropertyWithValue("name", teamName)
                .hasFieldOrPropertyWithValue("pitcherNumber", pitcherNumber);

        softly.assertThat(foundTeam.getPlayers())
                .hasSize(playerSize);

    }
}
