package com.dong.baseball.Repository;

import com.dong.baseball.Domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    List<Team> findAll();

    Optional<Team> findByTeamId(Long teamId);

    Optional<Team> findByTeamName(String teamName);
}
