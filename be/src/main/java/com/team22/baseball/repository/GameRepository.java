package com.team22.baseball.repository;

import com.team22.baseball.domain.Game;
import com.team22.baseball.domain.Team;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Long> {

    Optional<Game> findById(Long id);

    List<Game> findAll();

    @Query("SELECT TEAM.id as id, TEAM.name as name, TEAM.is_home as is_home, TEAM.selected as selected, TEAM.game_id as game_id FROM GAME INNER JOIN TEAM ON GAME.id = TEAM.game_id AND TEAM.name = :title;")
    Optional<Team> findTeamByTitle(String title);
}
