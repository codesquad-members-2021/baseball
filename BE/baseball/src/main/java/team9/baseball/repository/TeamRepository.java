package team9.baseball.repository;

import org.springframework.data.repository.CrudRepository;
import team9.baseball.domain.aggregate.team.Team;

public interface TeamRepository extends CrudRepository<Team, Integer> {
}
