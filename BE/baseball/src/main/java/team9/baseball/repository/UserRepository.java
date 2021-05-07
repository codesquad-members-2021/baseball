package team9.baseball.repository;

import org.springframework.data.repository.CrudRepository;
import team9.baseball.domain.aggregate.user.User;
import team9.baseball.domain.enums.Venue;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByCurrentGameIdAndCurrentGameVenue(Long currentGameId, Venue currentGameVenue);
}
