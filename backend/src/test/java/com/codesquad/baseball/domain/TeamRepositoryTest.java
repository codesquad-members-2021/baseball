package com.codesquad.baseball.domain;

import com.codesquad.baseball.domain.team.Player;
import com.codesquad.baseball.domain.team.PlayerRole;
import com.codesquad.baseball.domain.team.Team;
import com.codesquad.baseball.domain.team.TeamRepository;
import com.codesquad.baseball.exceptions.notfound.TeamNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class TeamRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(TeamRepositoryTest.class);
    private static final String[] testTeamNames = {
            "댕댕 타이거즈",
            "냥냥 라이온즈",
            "짹짹 이글스",
    };
    private static final String[] playerNames = {
            "댕현진",
            "댕신수",
            "댕찬호",
    };

    @Autowired
    private TeamRepository teamRepository;

    @Test
    @DisplayName("팀을 생성하고, 생성된 팀을 조회할 수 있어야 함")
    void testCreateTeams() {
        for (String teamName : testTeamNames) {
            Team team = createTeam(teamName);
            Team foundTeam = findTeamById(team.getId());
            testCreateTeam(foundTeam, teamName);
        }
    }

    @Test
    @DisplayName("팀에 플레이어를 추가할 수 있어야 함")
    void testInsertPlayerIntoTeam() {
        Team team = createTeam(testTeamNames[0]);
        List<Player> players = createPlayers();
        players.forEach(team::addPlayer);
        teamRepository.save(team);
        team = findTeamById(team.getId());
        assertThat(team.numberOfPlayer()).isEqualTo(players.size());
        logger.debug("team : {}", team);
    }

    private List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerNames.length; i++) {
            Player player = createHitter(playerNames[i], i + 3);
            players.add(player);
        }
        return players;
    }

    private void testCreateTeam(Team team, String teamName) {
        logger.debug("saved team : {}", team);
        assertThat(team.isSameTeam(teamName)).isTrue();
    }

    private Team createTeam(String teamName) {
        Team team = new Team(teamName);
        return teamRepository.save(team);
    }

    private Team findTeamById(int id) {
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
    }

    private Player createHitter(String playerName, int uniformNumber) {
        return new Player.Builder()
                .playerName(playerName)
                .uniformNumber(uniformNumber)
                .role(PlayerRole.HITTER)
                .build();
    }
}
