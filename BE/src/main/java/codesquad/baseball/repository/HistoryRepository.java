package codesquad.baseball.repository;

import codesquad.baseball.domain.History;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends CrudRepository<History, Long> {
}
