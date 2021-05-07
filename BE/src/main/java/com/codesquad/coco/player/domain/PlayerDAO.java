package com.codesquad.coco.player.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerDAO {
    private JdbcTemplate template;

    public PlayerDAO(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Player> findByTeamName(String teamName) {
        String sql = "SELECT p.id as pid, p.type, p.name, r.id as rid, r.outs, r.hits, r.at_bat, r.average " +
                "FROM player p " +
                "inner JOIN record r ON r.player = p.id " +
                "WHERE p.team = '" + teamName + "' order by p.id;";

        List<Player> players = new ArrayList<>();

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

    public Player findById(Long id) {
        String sql = "select p.id as pid, p.name, p.type, r.id as rid, r.outs, r.hits, r.at_bat, r.average " +
                "from player p " +
                "inner JOIN record r ON r.player = p.id " +
                "where p.id= " + id;

        List<Player> query = template.query(sql, (rs, rowNum) -> {
            Record record = new Record(
                    rs.getLong("rid"),
                    rs.getInt("at_bat"),
                    rs.getInt("hits"),
                    rs.getInt("outs"),
                    rs.getDouble("average")
            );
            Player player = new Player(
                    rs.getLong("pid"),
                    rs.getString("name"),
                    rs.getString("type"),
                    record
            );
            return player;
        });

        return query.get(0);
    }

    public void updateRecord(Record record) {
        String sql = "update record set at_bat = ?, hits = ?, outs = ?, average = ? where id = ?";

        template.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, record.getAtBat());
            ps.setInt(2, record.getHits());
            ps.setInt(3, record.getOuts());
            ps.setDouble(4, record.getAverage());
            ps.setLong(5, record.getId());
            return ps;
        });
    }
}
