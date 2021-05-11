package com.codesquad.team12.baseball.repository;

import com.codesquad.team12.baseball.model.Game;
import com.codesquad.team12.baseball.model.Inning;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {
    @Override
    List<Game> findAll();

    @Query("SELECT number, score FROM inning WHERE game_id =: gameId and team_id =: teamName")
    List<Inning> findInningByTeam(Long gameId, String teamName);
}
