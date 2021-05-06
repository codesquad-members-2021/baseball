package com.codesquad.coco;

import com.codesquad.coco.game.domain.GameDAO;
import com.codesquad.coco.game.domain.ScoreBoardDAO;
import com.codesquad.coco.game.domain.model.Game;
import com.codesquad.coco.game.domain.model.ScoreBoard;
import com.codesquad.coco.team.domain.Team;
import com.codesquad.coco.team.domain.TeamRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class ScoreTest {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    GameDAO gameDAO;
    @Autowired
    ScoreBoardDAO scoreBoardDAO;

    @Test
    @DisplayName("점수판 보기")
    void showScoreBoard() {
        Game bigMatch = gameDAO.findById(1L);
        Team home = bigMatch.getHome();
        Team away = bigMatch.getAway();

        ScoreBoard homeBoard = new ScoreBoard(bigMatch.getId(), home.getName());
        ScoreBoard awayBoard = new ScoreBoard(bigMatch.getId(), away.getName());

        Long homeBoardId = scoreBoardDAO.save(homeBoard);
        Long awayBoardId = scoreBoardDAO.save(awayBoard);

        Assertions.assertThat(homeBoardId).isEqualTo(3L);
        Assertions.assertThat(awayBoardId).isEqualTo(4L);

    }
}
