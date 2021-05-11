package com.codesquad.team12.baseball.repository;

import com.codesquad.team12.baseball.model.Playing;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayingRepository extends CrudRepository<Playing, Long> {
    @Query("SELECT `team_name`, `player_number`, `player_name`, `position`, `pa`, `hit`, `out`, `average`, `game_id` FROM playing WHERE game_id=:gameId and team_name=:teamName")
    List<Playing> findAllByTeam(Long gameId, String teamName);
}
