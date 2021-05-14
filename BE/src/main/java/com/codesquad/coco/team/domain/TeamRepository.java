package com.codesquad.coco.team.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, String> {

    Optional<Team> findTeamByName(String name);
}
