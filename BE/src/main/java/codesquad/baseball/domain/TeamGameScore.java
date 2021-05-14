package codesquad.baseball.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamGameScore {
    @JsonIgnore
    @Id
    private Long id;

    private int inningNumber;

    private int score;

    public TeamGameScore(int inningNumber, int score) {
        this.inningNumber = inningNumber;
        this.score = score;
    }

}
