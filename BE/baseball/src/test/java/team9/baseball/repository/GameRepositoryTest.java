package team9.baseball.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team9.baseball.domain.aggregate.game.Game;
import team9.baseball.domain.aggregate.team.Player;
import team9.baseball.domain.aggregate.team.Team;
import team9.baseball.domain.enums.Halves;

@SpringBootTest
@Transactional
class GameRepositoryTest {
    private TeamRepository teamRepository;
    private GameRepository gameRepository;

    @Autowired
    public GameRepositoryTest(TeamRepository teamRepository, GameRepository gameRepository) {
        this.teamRepository = teamRepository;
        this.gameRepository = gameRepository;
    }

    @BeforeEach
    void setUp() {
        Team testTeam = new Team("코드스쿼드");
        testTeam.addPlayer(1, new Player("아이작"));
        testTeam.addPlayer(2, new Player("쏭"));
        testTeam.addPlayer(3, new Player("쑤"));
        this.teamRepository.save(testTeam);

        Team testTeam2 = new Team("마스터즈");
        testTeam2.addPlayer(1, new Player("호눅스"));
        testTeam2.addPlayer(2, new Player("JK"));
        testTeam2.addPlayer(3, new Player("크롱"));
        this.teamRepository.save(testTeam2);
    }

    @Test
    @DisplayName("Game 생성 테스트")
    void create() {
        Team awayTeam = this.teamRepository.findById(1).get();
        Team homeTeam = this.teamRepository.findById(2).get();
        Game game = this.gameRepository.save(new Game(awayTeam, homeTeam));
        Assertions.assertThat(game.getAwayTeamId()).isEqualTo(awayTeam.getId());
        Assertions.assertThat(game.getHomeTeamId()).isEqualTo(homeTeam.getId());
        Assertions.assertThat(game.getBattingHistoryMap().size()).isEqualTo(awayTeam.getPlayerMap().size() + homeTeam.getPlayerMap().size());
        Assertions.assertThat(game.getCurrentInning()).isEqualTo(1);
        Assertions.assertThat(game.getCurrentHalves()).isEqualTo(Halves.TOP);
    }
}
