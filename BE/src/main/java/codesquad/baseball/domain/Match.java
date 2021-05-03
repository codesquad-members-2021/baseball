package codesquad.baseball.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class Match {
    @Id
    private Long id;

    private Long myTeamId;

    private Long counterTeamId;

    private boolean isHome;
}
