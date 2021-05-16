package baseball.repository;

import baseball.domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Long> {

    @Override
    List<Team> findAll();
}
