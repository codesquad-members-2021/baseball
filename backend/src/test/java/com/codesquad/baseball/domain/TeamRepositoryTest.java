package com.codesquad.baseball.domain;

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

    @Autowired
    private TeamRepository teamRepository;

    @Test
    @DisplayName("팀을 생성하고, 생성된 팀을 조회할 수 있어야 함")
    void testCreateTeam() {
        String teamName = "댕댕 타이거즈";
        Team team = new Team(teamName);
        teamRepository.save(team);
        logger.debug("saved team : {}", team);
        assertThat(team.isSameName(team)).isTrue();
    }
}
