package com.codesquad.team12.baseball.repository;

import com.codesquad.team12.baseball.model.Inning;
import org.springframework.data.repository.CrudRepository;

public interface InningRepository extends CrudRepository<Inning, Long> {
}
