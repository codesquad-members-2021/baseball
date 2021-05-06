package com.codesquad.coco.game.domain;

import com.codesquad.coco.game.domain.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {

}
