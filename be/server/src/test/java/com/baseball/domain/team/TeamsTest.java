package com.baseball.domain.team;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.baseball.domain.team.TeamFactory.createTeam;

class TeamsTest {
    private Teams teams;

    @BeforeEach
    void setUp() {
        teams = new Teams(
                createTeam("AWAY"),
                createTeam("HOME")
        );
    }

    @Test
    @DisplayName("공수가 바뀌면, 공격팀에는 새로운 점수판이 생기고, 수비팀은 투수가 바뀌어야 한다.")
    void switchRole() {
        // TODO:
    }
}
