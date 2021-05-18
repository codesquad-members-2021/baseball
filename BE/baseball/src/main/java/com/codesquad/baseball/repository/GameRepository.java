package com.codesquad.baseball.repository;

import com.codesquad.baseball.DTO.GameListDTO;
import com.codesquad.baseball.domain.Game;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {

    @Query("select game.id as gameId,\n" +
            "(Select team.name from game left join team on game.home_team_id = team.id where game.id = gameId) as homeTeamName,\n" +
            "game.home_team_id as homeTeamId,\n" +
            "(Select team.name from game left join team on game.away_team_id = team.id where game.id = gameId) as awayTeamName,\n" +
            "game.away_team_id as awayTeamId\n" +
            "From game;") // 게임이 가진 홈팀, 원정팀 아이디로 team 테이블에서 해당 팀의 이름까지 가져오게 했습니다.
    List<GameListDTO> browseAllGames();

}
