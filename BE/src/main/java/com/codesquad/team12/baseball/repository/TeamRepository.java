package com.codesquad.team12.baseball.repository;

import com.codesquad.team12.baseball.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
