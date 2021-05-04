package codesquad.baseball.repository;

import codesquad.baseball.domain.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {
}
