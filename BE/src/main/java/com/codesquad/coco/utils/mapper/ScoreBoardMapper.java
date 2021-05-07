package com.codesquad.coco.utils.mapper;

import com.codesquad.coco.game.domain.model.ScoreBoard;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreBoardMapper implements RowMapper<ScoreBoard> {
    @Override
    public ScoreBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ScoreBoard(
                rs.getLong("id"),
                rs.getLong("game"),
                rs.getString("team")
        );
    }
}
