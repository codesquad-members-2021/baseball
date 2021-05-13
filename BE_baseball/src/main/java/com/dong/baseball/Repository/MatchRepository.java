package com.dong.baseball.Repository;

import com.dong.baseball.Domain.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {

    @Override
    List<Match> findAll();

}
