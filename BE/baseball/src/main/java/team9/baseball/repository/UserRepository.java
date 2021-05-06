package team9.baseball.repository;

import org.springframework.data.repository.CrudRepository;
import team9.baseball.domain.aggregate.user.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
