package codesquad.team7.baseball.repository;

import codesquad.team7.baseball.game.BaseballGame;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BaseballGameRepository extends CrudRepository<BaseballGame, Long> {

    @Override
    List<BaseballGame> findAll();

    List<BaseballGame> findAllByWinnerIsNull();

}
