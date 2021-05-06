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
    //Team homeTeam;

    @NonNull
    private Long counterTeamId;
    //Team awayTeam;

    @NonNull
    private boolean isHome;

}
