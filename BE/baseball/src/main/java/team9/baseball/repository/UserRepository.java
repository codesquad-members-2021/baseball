package team9.baseball.repository;

import org.springframework.data.repository.CrudRepository;
import team9.baseball.domain.aggregate.user.User;
import team9.baseball.domain.enums.Venue;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    boolean existsByCurrentGameId(Long currentGameId);

    boolean existsByCurrentGameIdAndCurrentGameVenue(Long currentGameId, Venue currentGameVenue);

    Optional<User> findByIdAndEmailAndOauthResourceServer(Long id, String email, String oauthResourceServer);
}
