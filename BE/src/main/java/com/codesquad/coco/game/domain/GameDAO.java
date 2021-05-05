package com.codesquad.coco.game.domain;

import com.codesquad.coco.player.domain.PlayerDAO;
import com.codesquad.coco.team.domain.Team;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class GameDAO {

    private JdbcTemplate template;
    private PlayerDAO playerDAO;

    public GameDAO(DataSource dataSource, PlayerDAO playerDAO) {
        this.template = new JdbcTemplate(dataSource);
        this.playerDAO = playerDAO;
    }

    public void save(Game game) {
        String sql = "insert into game (home,away,user_type) values (?, ?,?)";
        template.update(sql, game.awayTeamName(), game.homeTeamName(), game.getUserType());
    }

    public Game findById(Long id) {
        String sql = "select g.id, g.home,g.away,g.user_type from game g where g.id = " + id;

        List<Game> query = template.query(sql, (rs, rowNum) -> {
            String homeTeamName = rs.getString("home");
            String awayTeamName = rs.getString("away");
            Team homeTeam = new Team(
                    homeTeamName, playerDAO.findByTeamName(homeTeamName)
            );
            Team awayTeam = new Team(
                    awayTeamName, playerDAO.findByTeamName(awayTeamName)
            );
            Game game = new Game(
                    rs.getLong("id"),
                    homeTeam,
                    awayTeam,
                    rs.getString("user_type")
            );

            return game;
        });

        return query.get(0);

    }


}
