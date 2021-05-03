package codesquad.baseball.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class PlayerGameInfo {
    @Id
    private Long id;
    private Long average;
    private int battingOrder;
    private int plateAppearance;
    private int hits;
    private int out;

}
