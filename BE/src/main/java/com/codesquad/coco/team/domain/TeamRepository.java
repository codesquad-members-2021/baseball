package com.codesquad.coco.team.domain;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team,Long>{

    Optional<Team> findTeamByName(String name);
}
