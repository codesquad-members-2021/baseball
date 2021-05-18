package com.codesquad.baseball.repository;

import com.codesquad.baseball.domain.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
