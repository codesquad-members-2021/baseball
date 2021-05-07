package team9.baseball.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team9.baseball.domain.aggregate.team.Player;
import team9.baseball.domain.aggregate.team.Team;

@SpringBootTest
@Transactional
class TeamRepositoryTest {
    private TeamRepository teamRepository;

    @Autowired
    public TeamRepositoryTest(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Test
    @DisplayName("Team 생성 테스트")
    void create() {
        Team testTeam2 = new Team("마스터즈");
        testTeam2.addPlayer(1, new Player("호눅스"));
        testTeam2.addPlayer(2, new Player("JK"));
        testTeam2.addPlayer(3, new Player("크롱"));
        Team saved = this.teamRepository.save(testTeam2);
        Assertions.assertThat(saved.getName()).isEqualTo("마스터즈");
        Assertions.assertThat(saved.getPlayerMap().size()).isEqualTo(3);
    }
}
