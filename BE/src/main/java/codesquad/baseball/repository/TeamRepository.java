package codesquad.baseball.repository;

import codesquad.baseball.domain.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
