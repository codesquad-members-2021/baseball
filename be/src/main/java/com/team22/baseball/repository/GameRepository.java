package com.team22.baseball.repository;

import com.team22.baseball.domain.Game;
import com.team22.baseball.domain.Team;
import com.team22.baseball.dto.response.GameDto;
import com.team22.baseball.dto.response.PlayerInfoDto;
import com.team22.baseball.dto.response.TeamInfoDto;
import com.team22.baseball.dto.response.TeamTypeDto;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Long> {

    Optional<Game> findById(Long id);

    List<Game> findAll();

    @Query("SELECT TEAM.id as id, TEAM.name as name, TEAM.is_home as is_home, TEAM.selected as selected, TEAM.game_id as game_id FROM GAME INNER JOIN TEAM ON GAME.id = TEAM.game_id AND TEAM.name = :title;")
    Optional<Team> findTeamByTitle(@Param("title") String title);

    @Query("SELECT home_group.id AS game_id, home_group.in_progress as in_progress ,home_group.home as home, away_group.away as away\n" +
            "FROM\n" +
            "(SELECT GAME.id AS id, GAME.in_progress AS in_progress,  TEAM.name AS home, TEAM.selected as selected\n" +
            "FROM GAME INNER JOIN TEAM ON GAME.id = TEAM.game_id\n" +
            "WHERE TEAM.is_home = true) as home_group\n" +
            "INNER JOIN\n" +
            "(SELECT GAME.id AS id, TEAM.name AS away, TEAM.selected as selected\n" +
            "FROM GAME INNER JOIN TEAM ON GAME.id = TEAM.game_id\n" +
            "WHERE TEAM.is_home = false) as away_group\n" +
            "ON home_group.id = away_group.id;")
    List<GameDto> findAllGame();

    @Query("SELECT TEAM.name \n" +
            "FROM TEAM \n" +
            "WHERE TEAM.game_id = (SELECT TEAM.game_id FROM TEAM WHERE TEAM.name = :title);")
    List<TeamTypeDto> findTeamListByTeamTitle(@Param("title") String title);

    @Query("SELECT T.name, T.selected, T.is_home\n" +
            "FROM TEAM T\n" +
            "WHERE T.name = :title;")
    Optional<TeamInfoDto> findTeamInfoByTitle(@Param("title") String title);

    @Query("SELECT P.name, P.uniform_number, P.is_pitcher\n" +
            "FROM PLAYER AS P INNER JOIN TEAM T on P.team_id = T.id\n" +
            "WHERE T.name = :title;")
    List<PlayerInfoDto> findPlayerListByTeamTitle(@Param("title") String title);


    @Modifying
    @Query("UPDATE TEAM SET TEAM.selected=true WHERE TEAM.name = :teamTitle;")
    void updateSelectedTeamByTitle(@Param("teamTitle") String teamTitle);

}

