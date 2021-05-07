package com.codesquad.coco.game.domain.DAO;

import com.codesquad.coco.game.domain.model.Innings;
import com.codesquad.coco.game.domain.model.ScoreBoard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Component
public class ScoreBoardDAO {

    private JdbcTemplate template;

    private InningsDAO inningsDAO;

    public ScoreBoardDAO(DataSource dataSource, InningsDAO inningsDAO) {
        this.template = new JdbcTemplate(dataSource);
        this.inningsDAO = inningsDAO;
    }

    public Long save(ScoreBoard board) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into score_board (game,team) values (?, ?)";

        template.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, board.getGameId());
            ps.setString(2, board.teamName());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    public ScoreBoard findByGameIdAndTeamName(Long id, String teamName) {
        String sql = "select s.id, s.game,s.team from score_board s where s.game = " + id + " and s.team = '" + teamName + "'";


        List<ScoreBoard> query = template.query(sql, (rs, rowNum) -> {

            List<Innings> innings = inningsDAO.findAllById(rs.getLong("id"));

            ScoreBoard board = new ScoreBoard(
                    rs.getLong("id"),
                    rs.getLong("game"),
                    rs.getString("team"),
                    innings
            );

            return board;
        });
        return query.get(0);
    }

    public void saveInnings(Innings innings) {
        String sql = "insert into innings (score_board, score, score_board_key) values (?,?,?)";
        template.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, innings.getScoreBoard());
            ps.setInt(2, innings.getScore());
            ps.setInt(3, innings.getInning());
            return ps;
        });
    }
}
