package codesquad.baseball.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import static codesquad.baseball.domain.Constants.HIT;
import static codesquad.baseball.domain.Constants.OUT;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class History {
    @Id
    @JsonIgnore
    private Long id;
    private String actionName;
    private int strike;
    private int ball;
    private int out;

    @JsonIgnore
    public boolean isActionOut() {
        return actionName.equals(OUT);
    }

    @JsonIgnore
    public boolean isActionHit() {
        return actionName.equals(HIT);
    }
}
