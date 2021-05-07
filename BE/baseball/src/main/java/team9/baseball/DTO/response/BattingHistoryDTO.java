package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team9.baseball.domain.aggregate.game.BattingHistory;
import team9.baseball.domain.aggregate.team.Team;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BattingHistoryDTO {
    private int uniform_number;
    private String name;
    private int appear_count;
    private int hit_count;
    private double hit_ratio;
    private boolean playing;


    public static BattingHistoryDTO of(Team team, BattingHistory battingHistory, int playingUniformNumber) {
        double hitRatio = 0;
        if (battingHistory.getAppear() != 0) {
            hitRatio = (double) battingHistory.getHits() / (double) battingHistory.getAppear();
        }

        return builder()
                .uniform_number(battingHistory.getBatterUniformNumber())
                .name(team.getPlayerName(battingHistory.getBatterUniformNumber()))
                .appear_count(battingHistory.getAppear())
                .hit_count(battingHistory.getHits())
                .hit_ratio(hitRatio)
                .playing(battingHistory.getBatterUniformNumber() == playingUniformNumber)
                .build();
    }
}
