package com.team22.baseball.repository;

import com.team22.baseball.domain.Game;
import com.team22.baseball.domain.Player;
import com.team22.baseball.domain.Team;
import com.team22.baseball.domain.TeamScore;
import com.team22.baseball.dto.response.GameList.GameInfo;
import com.team22.baseball.dto.response.TeamSelect.NextPlayerInfoDto;
import com.team22.baseball.dto.response.TeamSelect.PlayerInfoDto;
import com.team22.baseball.dto.response.TeamSelect.TeamInfoDto;
import com.team22.baseball.dto.response.TeamSelect.TeamTypeDto;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Long> {

    @Override
    Optional<Game> findById(Long id);

    @Override
    List<Game> findAll();

    @Query("SELECT * FROM GAME WHERE GAME.id = :id;")
    Optional<Game> findGameById(@Param("id") Long id);

    @Query("SELECT TEAM.id as id, TEAM.name as name, TEAM.is_home as is_home, TEAM.selected as selected, TEAM.game_id as game_id FROM GAME INNER JOIN TEAM ON GAME.id = TEAM.game_id AND TEAM.name = :title;")
    Optional<Team> findTeamByTitle(@Param("title") String title);

    @Query("SELECT * FROM PLAYER AS P WHERE P.name = :name;")
    Optional<Player> findPlayerByName(@Param("name") String name);

    @Query("SELECT * FROM TEAM WHERE TEAM.game_id = (SELECT GAME.id FROM GAME WHERE GAME.id = :id);")
    List<Team> findTeamById(@Param("id") Long id);

    @Query("SELECT home_group.id AS game_id, home_group.in_progress as in_progress ,home_group.home as home, away_group.away as away\n" +
            "FROM\n" +
            "(SELECT GAME.id AS id, GAME.in_progress AS in_progress, TEAM.name AS home, TEAM.selected as selected\n" +
            "FROM GAME INNER JOIN TEAM ON GAME.id = TEAM.game_id\n" +
            "WHERE TEAM.is_home = true) as home_group\n" +
            "INNER JOIN\n" +
            "(SELECT GAME.id AS id, TEAM.name AS away, TEAM.selected as selected\n" +
            "FROM GAME INNER JOIN TEAM ON GAME.id = TEAM.game_id\n" +
            "WHERE TEAM.is_home = false) as away_group\n" +
            "ON home_group.id = away_group.id;")
    List<GameInfo> findAllGame();

    @Query("SELECT TEAM.name FROM TEAM WHERE TEAM.game_id = (SELECT TEAM.game_id FROM TEAM WHERE TEAM.name = :title);")
    List<TeamTypeDto> findTeamListByTeamTitle(@Param("title") String title);

    @Query("SELECT T.name, T.selected, T.is_home FROM TEAM T WHERE T.name = :title;")
    Optional<TeamInfoDto> findTeamInfoByTitle(@Param("title") String title);

    @Query("SELECT * FROM TEAM_SCORE WHERE TEAM_SCORE.team_id = (SELECT TEAM.id FROM TEAM WHERE TEAM.name = :name);")
    List<TeamScore> findTeamScoreByName(@Param("name") String name);

    @Query("SELECT P.name, P.uniform_number, P.is_pitcher\n" +
            "FROM PLAYER AS P INNER JOIN TEAM T on P.team_id = T.id\n" +
            "WHERE T.name = :title;")
    List<PlayerInfoDto> findPlayerListByTeamTitle(@Param("title") String title);

    @Query("SELECT P.name, P.uniform_number, P.plate_appearance, P.hits\n"+
            "FROM PLAYER AS P INNER JOIN TEAM T on P.team_id = T.id\n" +
            "WHERE uniform_number = :nextUniformNumber AND T.name = :teamName;")
    Optional<NextPlayerInfoDto> findNextPlayerByNumberAndTeamName(@Param("nextUniformNumber") int nextUniformNumber, @Param("teamName") String teamName);

    @Modifying
    @Query("UPDATE TEAM SET TEAM.selected=:selected WHERE TEAM.name = :teamTitle;")
    void updateSelectedTeamByTitle(@Param("teamTitle") String teamTitle, @Param("selected") boolean selected);

    @Modifying
    @Query("UPDATE PLAYER SET plate_appearance= :plate_appearance, hits= :hits, outs= :outs WHERE PLAYER.name = :name;")
    void updatePlayerInfo(@Param("name") String name, @Param("plate_appearance") int plate_appearance, @Param("hits") int hits, @Param("outs") int outs);

    @Modifying
    @Query("INSERT INTO TEAM_SCORE(team_id, round, score)\n" +
            "VALUES((SELECT TEAM.id FROM TEAM WHERE TEAM.name = :teamName), :round,:score)")
    void insertTeamScore(@Param("teamName") String teamName, @Param("round") int round, @Param("score") int score);

    @Modifying
    @Query("UPDATE GAME SET GAME.in_progress = :inProgress WHERE GAME.id = ( SELECT TEAM.id FROM TEAM WHERE TEAM.name = :teamTitle );")
    void updateGameStatusByTitle(@Param("teamTitle") String teamTitle, @Param("inProgress") boolean inProgress);

    @Query("UPDATE GAME SET GAME.round = 0, GAME.in_progress= false WHERE GAME.id = :gameId;")
    void resetGame(@Param("gameId") Long gameId);

    @Query("UPDATE TEAM SET TEAM.selected = false WHERE TEAM.game_id = :gameId;")
    void resetTeam(@Param("gameId") Long gameId);

    @Query("DELETE FROM TEAM_SCORE WHERE TEAM_SCORE.team_id = :teamId;")
    void resetTeamScore(@Param("teamId") Long teamId);

    @Query("UPDATE PLAYER SET PLAYER.hits = 0, PLAYER.outs=0, PLAYER.plate_appearance = 0 WHERE PLAYER.team_id = :teamId;")
    void resetPlayer(@Param("teamId") Long teamId);

}
