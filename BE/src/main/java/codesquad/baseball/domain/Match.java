package codesquad.baseball.domain;

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
    //myteam 에 대해 isHome이 true일 경우, myTeam 수비 먼저, 공격 나중에. 초-수비/말-공격
}
