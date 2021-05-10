package com.codesquad.coco.player.domain;

import com.codesquad.coco.player.domain.model.Player;
import com.codesquad.coco.player.domain.model.Record;
import com.codesquad.coco.utils.mapper.PlayerMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.codesquad.coco.utils.SQL.*;

@Component
public class PlayerDAO {
    private NamedParameterJdbcTemplate template;
    private PlayerMapper playerMapper = new PlayerMapper();

    public PlayerDAO(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Player> findByTeamName(String teamName) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("teamName", teamName);
        return template.query(FIND_PLAYER_BY_TEAM_NAME, parameter, playerMapper);

    }

    public Player findById(Long id) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("id", id);
        return template.queryForObject(FIND_PLAYER_BY_PLAYER_ID, parameter, playerMapper);
    }

    public void updateRecord(Record record) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("atBat", record.getAtBat());
        parameter.addValue("hits", record.getHits());
        parameter.addValue("outs", record.getOuts());
        parameter.addValue("id", record.getId());
        template.update(UPDATE_PLAYER_RECORD, parameter);
    }
}
