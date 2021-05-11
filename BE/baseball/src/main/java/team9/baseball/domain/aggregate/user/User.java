package team9.baseball.domain.aggregate.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import team9.baseball.domain.enums.ResourceOwner;
import team9.baseball.domain.enums.Venue;
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
        this.oauthAccessTokenMap.put(oauthAccessToken.getResourceOwner(), oauthAccessToken);
    }

    public String getAccessToken(ResourceOwner resourceOwner) {
        OauthAccessToken oauthAccessToken = oauthAccessTokenMap.getOrDefault(resourceOwner.name(), null);
        if (oauthAccessToken == null) {
            throw new NotFoundException(resourceOwner.name() + "의 access token이 존재하지 않습니다.");
        }
        return oauthAccessToken.getAccessToken();
    }
}
