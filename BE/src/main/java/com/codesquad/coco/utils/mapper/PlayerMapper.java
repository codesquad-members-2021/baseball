package com.codesquad.coco.utils.mapper;

import com.codesquad.coco.player.domain.model.Player;
import com.codesquad.coco.player.domain.model.Record;
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
                rs.getInt("outs")
        );
        return new Player(
                rs.getLong("pid"),
                rs.getString("name"),
                rs.getString("type"),
                record
        );
    }
}
