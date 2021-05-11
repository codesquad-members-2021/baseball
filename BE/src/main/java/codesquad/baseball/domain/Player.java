package codesquad.baseball.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    @Id
    private Long id;

    private String name;

    private PlayerGameInfo playerGameInfo;
    private List<History> historyList;

    public Player addHistory(List<History> histories) {
        historyList.addAll(histories);
        return this;
    }

    public void clearHistory() {
        historyList.clear();
    }

    @JsonIgnore
    public boolean isPitcher() {
        return playerGameInfo.getRole().equals(PlayerGameInfo.PITCHER);
    }

    @JsonIgnore
    public void addPitchCount(int pitches) {
        getPlayerGameInfo().addPitchCount(pitches);
    }
}
