package com.codesquad.team12.baseball.repository;

import com.codesquad.team12.baseball.model.Inning;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InningRepository extends CrudRepository<Inning, Long> {
    @Query("SELECT team_name, number, score, game_id FROM inning WHERE game_id=:gameId and team_name=:teamName")
    List<Inning> findAllByTeam(Long gameId, String teamName);
}
