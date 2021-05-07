package baseball.repository;

import baseball.service.dto.RecordDTO;
import baseball.domain.Team;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Long> {

    @Query("select at_bat, hit, `out`, average, name, position from record left join member on record.member = id where id = :id")
    Optional<RecordDTO> findRecordByMemberId(Long id);
}
