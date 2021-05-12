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

    @Test
    @DisplayName("proceedToNextBase 를 하면 타자가 바뀐다.")
    void proceedToNextBase_changePitcher() {
        // TODO:
    }

    @Test
    @DisplayName("삼루가 true 일 경우에만, proceedToNextBase 를 했을 때 점수가 증가해야한다.")
    void proceedToNextBase_fullBase() {
        // TODO:
    }
}
