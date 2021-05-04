package com.codesquad.baseball.domain;

import com.codesquad.baseball.exceptions.TeamNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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

    private void testCreateTeam(Team team, String teamName) {
        logger.debug("saved team : {}", team);
        assertThat(team.isSameName(teamName)).isTrue();
    }

    private Team createTeam(String teamName) {
        Team team = new Team(teamName);
        return teamRepository.save(team);
    }

    private Team findTeamById(int id) {
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
    }

}
