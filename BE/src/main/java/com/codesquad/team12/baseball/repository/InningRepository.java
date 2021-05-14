package com.codesquad.team12.baseball.repository;

import com.codesquad.team12.baseball.model.Inning;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InningRepository extends CrudRepository<Inning, Long> {
    @Query("SELECT team_name, number, score, game_id FROM inning WHERE game_id=:gameId and team_name=:teamName")
    List<Inning> findAllByTeam(Long gameId, String teamName);

    @Query("SELECT team_name, number, score, game_id FROM inning WHERE game_id=:gameId and team_name=:teamName and number=:number")
    Inning findByTeam(Long gameId, String teamName, Integer number);

    @Modifying
    @Query("UPDATE inning SET score=:score WHERE game_id=:gameId AND team_name=:teamName AND number=:number")
    void updateInning(Long gameId, String teamName, Integer number, Integer score);
}
