package com.codesquad.team12.baseball.repository;

import com.codesquad.team12.baseball.model.Playing;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayingRepository extends CrudRepository<Playing, Long> {
    @Query("SELECT `team_name`, `player_number`, `player_name`, `position`, `pa`, `hit`, `out`, `average`, `game_id` FROM playing WHERE game_id=:gameId and team_name=:teamName")
    List<Playing> findAllByTeam(Long gameId, String teamName);

    @Query("SELECT `team_name`, `player_number`, `player_name`, `position`, `pa`, `hit`, `out`, `average`, `game_id` FROM playing WHERE game_id=:gameId and team_name=:teamName and player_number=:playerNumber")
    Playing findByTeam(Long gameId, String teamName, Integer playerNumber);

    @Modifying
    @Query("UPDATE playing SET pa=:pa, hit=:hit, `out`=:out WHERE game_id=:gameId AND team_name=:teamName AND player_number=:playerNumber")
    void updatePlaying(Long gameId, String teamName, Integer playerNumber, Integer pa, Integer hit, Integer out);
}
