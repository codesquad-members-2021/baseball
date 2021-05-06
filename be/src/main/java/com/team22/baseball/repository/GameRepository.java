package com.team22.baseball.repository;

import com.team22.baseball.domain.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Long> {

    Optional<Game> findById(Long id);

}
