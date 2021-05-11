package codesquad.baseball.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Match {
    @Id
    private Long id;

    @NonNull
    private Long myTeamId;

    @NonNull
    private Long counterTeamId;

    @NonNull
    private Inning currentInning;

    @NonNull
    private boolean isHome;

    @JsonIgnore
    public Long getHomeTeamId() {
        if (isHome) {
            return myTeamId;
        }
        return counterTeamId;
    }

    @JsonIgnore
    public Long getExpeditionTeamId() {
        if (isHome) {
            return counterTeamId;
        }
        return myTeamId;
    }

    @JsonIgnore
    public Long getOtherTeamId(Long teamId) {
        if (teamId.equals(counterTeamId)) {
            return myTeamId;
        }
        if (teamId.equals(myTeamId)) {
            return counterTeamId;
        }
        return -1L;
    }
}
