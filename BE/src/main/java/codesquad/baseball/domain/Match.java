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
    private boolean isHome;

}
