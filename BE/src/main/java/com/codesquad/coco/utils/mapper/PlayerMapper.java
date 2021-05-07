package com.codesquad.coco.utils.mapper;

import com.codesquad.coco.player.domain.Player;
import com.codesquad.coco.player.domain.Record;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper implements RowMapper<Player> {
    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        Record record = new Record(
                rs.getLong("rid"),
                rs.getInt("at_bat"),
                rs.getInt("hits"),
                rs.getInt("outs"),
                rs.getDouble("average")
        );
        return new Player(
                rs.getLong("pid"),
                rs.getString("name"),
                rs.getString("type"),
                record
        );
    }
}
