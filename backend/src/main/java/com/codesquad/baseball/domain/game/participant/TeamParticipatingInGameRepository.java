package com.codesquad.baseball.domain.game.participant;

import org.springframework.data.repository.CrudRepository;

public interface TeamParticipatingInGameRepository extends CrudRepository<TeamParticipatingInGame, Integer> {
}
