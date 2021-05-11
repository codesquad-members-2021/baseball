package codesquad.baseball.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private int battingOrder;
    private String role;
    private int pitchCount;

    private int plateAppearance;
    private int hits;
    private int out;
    private Long average;

    @JsonIgnore
    public void addPitchCount(int pitches) {
        pitchCount += pitches;
    }

    @JsonIgnore
    public void updatePlayerGameInfo(boolean hitSuccess, boolean isOut) {
        this.plateAppearance += 1;
        if (hitSuccess) {
            this.hits += 1;
            return;
        }
        if (isOut) {
            this.out += 1;
        }
        this.average = (long) hits / (long) plateAppearance;
    }

}
