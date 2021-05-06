package team9.baseball.domain.aggregate.game;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import team9.baseball.domain.enums.Halves;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inning {
    @Id
    private Long id;

    private Integer inning;

    private Halves halves;

    private int score;

    private String keyInGame;

    @MappedCollection(idColumn = "inning_id", keyColumn = "index_in_inning")
    List<PitchHistory> pitchHistoryList = new ArrayList<>();

    public Inning(Integer inning, Halves halves) {
        this.inning = inning;
        this.halves = halves;
        this.score = 0;
        this.keyInGame = acquireKeyInGame(inning, halves);
    }

    public void plusScore() {
        this.score++;
    }

    public static String acquireKeyInGame(Integer inning, Halves halves) {
        return inning + halves.toString();
    }
}
