package com.codesquad.coco;


import com.codesquad.coco.game.domain.DAO.GameDAO;
import com.codesquad.coco.game.domain.model.Game;
import com.codesquad.coco.player.domain.UserType;
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


@Transactional
@SpringBootTest
public class GameTest {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    GameDAO gameDAO;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    @DisplayName("게임 만들기")
    void playGame() {
        Team ssg = teamRepository.findTeamByName("SSG 랜더스").get();
        Team doSan = teamRepository.findTeamByName("두산 베어스").get();

        Game bigMatch = new Game(ssg, doSan, UserType.HOME);
        Long gameId = gameDAO.save(bigMatch);
        Assertions.assertThat(gameId).isEqualTo(2L);
        //todo : 게임은 만들어 지면서 스코어 보드도 만들어야 한다.
    }

    @Test
    @DisplayName("게임 찾기")
    void showGame() {
        Game bigMatch = gameDAO.findById(1L);

        logger.info(bigMatch.toString());
    }
}