package com.codesquad.baseball.repository;

import com.codesquad.baseball.domain.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {

}
