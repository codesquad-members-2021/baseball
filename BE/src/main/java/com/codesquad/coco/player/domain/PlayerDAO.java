package com.codesquad.coco.player.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.Set;

@Component
public class PlayerDAO {
    private JdbcTemplate template;

    public PlayerDAO(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public Set<Player> findByTeamName(String teamName) {
        // todo :  선수 순서 보장
        String sql = "SELECT p.id as pid, p.type, p.name, r.id as rid, r.outs, r.hits, r.at_bat, r.average " +
                "FROM player p " +
                "inner JOIN record r ON r.player = p.id " +
                "WHERE p.team = '" + teamName + "' order by p.id;";

        Set<Player> players = new HashSet<>();

        template.query(sql, (rs, rowNum) -> {
            Record record = new Record(
                    rs.getLong("rid"),
                    rs.getInt("at_bat"),
                    rs.getInt("hits"),
                    rs.getInt("outs"),
                    rs.getDouble("average")
            );
            players.add(new Player(
                    rs.getLong("pid"),
                    rs.getString("name"),
                    rs.getString("type"),
                    record
            ));
            return null;
        });

        return players;
    }

}
