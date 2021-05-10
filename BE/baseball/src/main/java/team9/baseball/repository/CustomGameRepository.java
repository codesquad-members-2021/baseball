package team9.baseball.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import team9.baseball.DTO.response.GameDescriptionDTO;

import java.util.List;

@Repository
public interface CustomGameRepository {
    @Query("select SG.id, SG.away_team, SG.home_team, away_user.email as `away_user_email`, home_user.email as `home_user_email`, SG.status from " +
            "( " +
            "select G.id as `id`, T1.name as `away_team`, T2.name as `home_team`, G.status as `status` from game G " +
            "left join team T1 on G.away_team_id = T1.id " +
            "left join team T2 on G.home_team_id = T2.id " +
            ") SG " +
            "left join `user` away_user on SG.id = away_user.current_game_id and away_user.current_game_venue = 'AWAY' " +
            "left join `user` home_user on SG.id = home_user.current_game_id and home_user.current_game_venue = 'HOME'")
    List<GameDescriptionDTO> findAllGameDescription();
}
