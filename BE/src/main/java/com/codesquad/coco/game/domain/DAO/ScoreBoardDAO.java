package com.codesquad.coco.game.domain.DAO;

import com.codesquad.coco.game.domain.model.Innings;
import com.codesquad.coco.game.domain.model.ScoreBoard;
import com.codesquad.coco.utils.mapper.ScoreBoardMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.codesquad.coco.utils.BASEBALL_SQLKt.*;

@Component
public class ScoreBoardDAO {


    private InningsDAO inningsDAO;
    private NamedParameterJdbcTemplate template;
    private ScoreBoardMapper scoreBoardMapper = new ScoreBoardMapper();

    public ScoreBoardDAO(InningsDAO inningsDAO, NamedParameterJdbcTemplate template) {
        this.inningsDAO = inningsDAO;
        this.template = template;
    }

    public Long save(ScoreBoard board) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("game", board.getGameId());
        parameter.addValue("team", board.teamName());

        template.update(SCORE_BOARD_SAVE_SQL, parameter, keyHolder);

        return keyHolder.getKey().longValue();
    }

    public ScoreBoard findByGameIdAndTeamName(Long id, String teamName) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("id", id);
        parameter.addValue("teamName", teamName);

        ScoreBoard board = template.queryForObject(FIND_SCORE_BOARD_SQL, parameter, scoreBoardMapper);
        List<Innings> innings = inningsDAO.findAllById(board.getId());
        innings.forEach(board::addInnings);
        return board;
    }

    public List<ScoreBoard> findByGameId(Long id) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("id", id);

        List<ScoreBoard> scoreBoards = template.query(FIND_SCORE_BOARDS_SQL, parameter, scoreBoardMapper);

        for (ScoreBoard board : scoreBoards) {
            List<Innings> innings = inningsDAO.findAllById(board.getId());
            innings.forEach(board::addInnings);
        }
        return scoreBoards;
    }


    public void saveInnings(Innings innings) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("score_board", innings.getScoreBoard());
        parameter.addValue("score", innings.getScore());
        parameter.addValue("score_board_key", innings.getInning());

        template.update(INNINGS_SAVE_SQL, parameter);
    }

}
