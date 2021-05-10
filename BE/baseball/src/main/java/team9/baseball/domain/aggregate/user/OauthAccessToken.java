package team9.baseball.domain.aggregate.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import team9.baseball.domain.enums.ResourceServer;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OauthAccessToken {
    @Id
    private Long id;

    private String resourceServer;

    private String accessToken;

    public OauthAccessToken(ResourceServer resourceServer, String accessToken) {
        this.resourceServer = resourceServer.name();
        this.accessToken = accessToken;
    }
}
