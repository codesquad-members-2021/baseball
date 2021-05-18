package team9.baseball.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team9.baseball.domain.aggregate.user.User;
import team9.baseball.domain.enums.ResourceServer;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    private UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void 유저생성조회테스트() {
        User user = new User("isaac56@naver.com", ResourceServer.GITHUB);
        User saved = userRepository.save(user);

        Assertions.assertThat(user.getEmail()).isEqualTo(saved.getEmail());

        User found = userRepository.findById(saved.getId()).get();
        Assertions.assertThat(found.getEmail()).isEqualTo(saved.getEmail());
    }
}
