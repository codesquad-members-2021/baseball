package com.codesquad.coco.utils.mapper;

import com.codesquad.coco.game.domain.model.Innings;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InningsMapper implements RowMapper<Innings> {
    @Override
    public Innings mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Innings(
                rs.getLong("id"),
                rs.getLong("score_board"),
                rs.getInt("score"));
    }
}
