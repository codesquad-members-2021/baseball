package com.baseball.domain.team;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.baseball.domain.team.TeamFactory.createTeam;

class TeamTest {
    private Team team;

    @BeforeEach
    void setUp() {
        team = createTeam("TEAM");
    }

    @Test
    @DisplayName("pushScore 를 하면, 팀에 값이 0인 점수판이 추가되어야 한다.")
    void pushScore() {
        // TODO:
    }

    @Test
    @DisplayName("increaseScore 를 하면, 팀의 마지막 점수판이 증가되어야 한다.")
    void increaseScore() {
        // TODO:
    }

    @Test
    @DisplayName("changePitcher 를 하면, 다음 투수로 변경되어야 한다.")
    void changePitcher() {
        // TODO:
    }

    @Test
    @DisplayName("playOffense 를 하면, HIT 일 경우 다음 타자로 변경되어야 한다.")
    void playOffense() {
        // TODO:
    }

    @Test
    @DisplayName("playDefense 를 하면, 투수가 play 를 한 것과 동일한 효과가 나타나야 한다.")
    void playDefense() {
        // TODO:
    }
}
