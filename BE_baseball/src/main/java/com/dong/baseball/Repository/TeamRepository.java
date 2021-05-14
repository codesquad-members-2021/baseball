package com.dong.baseball.Repository;

import com.dong.baseball.Domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Long> {

    @Override
    List<Team> findAll();

    @Override
    Optional<Team> findById(Long aLong);

    Optional<Team> findByTeamName(String teamName);
}
