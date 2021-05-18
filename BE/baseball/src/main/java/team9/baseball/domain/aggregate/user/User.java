package team9.baseball.domain.aggregate.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import team9.baseball.domain.enums.ResourceServer;
import team9.baseball.domain.enums.Venue;
import team9.baseball.exception.BadStatusException;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    private Long id;

    private String email;

    private Long currentGameId;

    private Venue currentGameVenue;

    private ResourceServer oauthResourceServer;

    public User(String email, ResourceServer oauthResourceServer) {
        this.email = email;
        this.oauthResourceServer = oauthResourceServer;
    }

    public void checkUserJoining() {
        if (this.currentGameId == null) {
            throw new BadStatusException(id + "사용자는 게임중이 아닙니다.");
        }
    }

    public void checkUserNotJoining() {
        if (this.currentGameId != null) {
            throw new BadStatusException(id + "사용자는 이미 게임중입니다.");
        }
    }
}
