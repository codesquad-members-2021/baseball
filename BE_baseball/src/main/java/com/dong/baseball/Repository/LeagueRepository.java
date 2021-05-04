package com.dong.baseball.Repository;

import com.dong.baseball.Domain.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeagueRepository extends CrudRepository<Match, Long> {
    List<Match> findAll();
}
