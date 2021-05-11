package com.baseball.domain.match;

import com.baseball.domain.player.Players;
import com.baseball.domain.team.Team;
import com.baseball.domain.team.Teams;
import com.baseball.exception.MatchOccupiedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MatchTest {
    private Match match;

    @BeforeEach
    public void setUp() {
        match = new Match(new Teams(
                new Team("AWAY", new Players(
                        new ArrayList<>(),
                        new ArrayList<>()
                )),
                new Team("HOME", new Players(
                        new ArrayList<>(),
                        new ArrayList<>()
                ))
        ));
    }

    @Test
    @DisplayName("이미 팀이 선택되었다면, 다시 팀을 고를 수 없다.")
    void selectTeam() {
        match.selectTeam("AWAY");
        assertThatExceptionOfType(MatchOccupiedException.class)
                .isThrownBy(() -> match.selectTeam("HOME"))
                .withMessage("다른 사람이 선점한 경우에는 게임에 참가할 수 없습니다.");
    }
}
