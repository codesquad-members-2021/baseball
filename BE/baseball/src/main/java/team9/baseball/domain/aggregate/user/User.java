package team9.baseball.domain.aggregate.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import team9.baseball.domain.enums.ResourceServer;
import team9.baseball.domain.enums.Venue;
import team9.baseball.exception.BadStatusException;
import team9.baseball.exception.NotFoundException;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    private Long id;

    private String email;

    private Long currentGameId;

    private Venue currentGameVenue;

    @MappedCollection(idColumn = "user_id", keyColumn = "resource_owner")
    private Map<String, OauthAccessToken> oauthAccessTokenMap = new HashMap<>();

    public User(String email, OauthAccessToken oauthAccessToken) {
        this.email = email;
        this.oauthAccessTokenMap.put(oauthAccessToken.getResourceServer(), oauthAccessToken);
    }

    public String getAccessToken(ResourceServer resourceServer) {
        OauthAccessToken oauthAccessToken = oauthAccessTokenMap.getOrDefault(resourceServer.name(), null);
        if (oauthAccessToken == null) {
            throw new NotFoundException(resourceServer.name() + "의 access token이 존재하지 않습니다.");
        }
        return oauthAccessToken.getAccessToken();
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
