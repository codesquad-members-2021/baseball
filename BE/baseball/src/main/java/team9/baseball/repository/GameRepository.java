package team9.baseball.repository;

import org.springframework.data.repository.CrudRepository;
import team9.baseball.domain.aggregate.game.Game;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long>, CustomGameRepository {
    List<Game> findAll();
}
