package com.codesquad.coco.game.domain.DAO;

import com.codesquad.coco.game.domain.model.Game;
import com.codesquad.coco.game.domain.model.ScoreBoard;
import com.codesquad.coco.player.domain.PlayerDAO;
import com.codesquad.coco.player.domain.UserType;
import com.codesquad.coco.team.domain.Team;
import com.codesquad.coco.utils.mapper.UserTeamNameMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static com.codesquad.coco.utils.SQL.FIND_USER_TEAM_NAME_SQL;
import static com.codesquad.coco.utils.SQL.GAME_SAVE_SQL;

@Component
public class GameDAO {

    private JdbcTemplate template;
    private PlayerDAO playerDAO;
    private ScoreBoardDAO boardDAO;
    private UserTeamNameMapper userTeamNameMapper = new UserTeamNameMapper();
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public GameDAO(DataSource dataSource, PlayerDAO playerDAO, ScoreBoardDAO boardDAO, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.template = new JdbcTemplate(dataSource);
        this.playerDAO = playerDAO;
        this.boardDAO = boardDAO;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Long save(Game game) {
        Long gameId = saveGame(game);
        ScoreBoard away = new ScoreBoard(gameId, game.awayTeamName());
        ScoreBoard home = new ScoreBoard(gameId, game.homeTeamName());
        saveScoreBoard(game, away);
        saveScoreBoard(game, home);
        return gameId;
    }

    private Long saveScoreBoard(Game game, ScoreBoard away) {
        Long scoreId = boardDAO.save(away);
        game.addScoreBoard(away);
        return scoreId;
    }

    private Long saveGame(Game game) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("home", game.homeTeamName());
        parameter.addValue("away", game.awayTeamName());
        parameter.addValue("user_type", game.getUserType().toString());

        namedParameterJdbcTemplate.update(GAME_SAVE_SQL, parameter, keyHolder);

        return keyHolder.getKey().longValue();
    }


    public Game findById(Long id) {
        String sql = "select g.id, g.home,g.away,g.user_type from game g where g.id = " + id;

        List<Game> query = template.query(sql, (rs, rowNum) -> {
            String homeTeamName = rs.getString("home");
            String awayTeamName = rs.getString("away");

            ScoreBoard homeScoreBoard = boardDAO.findByGameIdAndTeamName(id, homeTeamName);
            ScoreBoard awayScoreBoard = boardDAO.findByGameIdAndTeamName(id, awayTeamName);

            Team homeTeam = new Team(
                    homeTeamName, playerDAO.findByTeamName(homeTeamName)
            );
            Team awayTeam = new Team(
                    awayTeamName, playerDAO.findByTeamName(awayTeamName)
            );

            Game game = new Game(
                    rs.getLong("id"),
                    awayTeam,
                    homeTeam,
                    Collections.unmodifiableSet(new HashSet<>(
                            Arrays.asList(homeScoreBoard, awayScoreBoard))),
                    UserType.valueOf(rs.getString("user_type"))
            );

            return game;
        });

        return query.get(0);
    }


    public String findUserTeamNameByGameId(Long id) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject(FIND_USER_TEAM_NAME_SQL, parameter, userTeamNameMapper);
    }
}
