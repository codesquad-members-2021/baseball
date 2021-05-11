package com.codesquad.team12.baseball.repository;

import com.codesquad.team12.baseball.model.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {
    @Override
    List<Game> findAll();
}
