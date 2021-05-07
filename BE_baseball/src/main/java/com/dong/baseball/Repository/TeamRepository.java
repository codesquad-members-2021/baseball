package com.dong.baseball.Repository;

import com.dong.baseball.Domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team,Long> {
    List<Team> findAll();
}
