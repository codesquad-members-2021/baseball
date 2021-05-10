package codesquad.team7.baseball.game;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class TeamEnumTest {

    @Test
    @DisplayName("상대팀을 가져온다.")
    void oppositeTeam() {
        SoftAssertions softly = new SoftAssertions();
        TeamEnum home = TeamEnum.HOME;
        TeamEnum away = TeamEnum.AWAY;

        softly.assertThat(home.opposite()).isEqualTo(TeamEnum.AWAY);
        softly.assertThat(away.opposite()).isEqualTo(TeamEnum.HOME);

        softly.assertAll();
    }

}
