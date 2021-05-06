package team9.baseball.domain.aggregate.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import team9.baseball.domain.enums.ResourceOwner;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OauthAccessToken {
    @Id
    private Long id;

    private String resourceOwner;

    private String accessToken;

    public OauthAccessToken(ResourceOwner resourceOwner, String accessToken) {
        this.resourceOwner = resourceOwner.name();
        this.accessToken = accessToken;
    }
}
