package com.codesquad.coco;

import com.codesquad.coco.player.domain.Player;
import com.codesquad.coco.team.domain.Team;
import com.codesquad.coco.team.domain.TeamRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
public class TeamTest {

    @Autowired
    TeamRepository teamRepository;

    Logger logger = LoggerFactory.getLogger(TeamTest.class);

    @Test
    @DisplayName("선수 조회")
    void showPlayer() {
        Team ssg = teamRepository.findTeamByName("SSG 랜더스").get();
        List<Player> players = ssg.getPlayers();
        Assertions.assertThat(players).isNotNull();
        for (Player player : players) {
            logger.info("선수 {}", player.toString());
        }
    }
}
