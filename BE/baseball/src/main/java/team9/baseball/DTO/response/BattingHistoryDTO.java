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
    private int uniformNumber;
    private String name;
    private int appearCount;
    private int hitCount;
    private int outCount;
    private double hitRatio;
    private boolean playing;


    public static BattingHistoryDTO of(Team team, BattingHistory battingHistory, int playingUniformNumber) {
        return builder()
                .uniformNumber(battingHistory.getBatterUniformNumber())
                .name(team.getPlayerName(battingHistory.getBatterUniformNumber()))
                .appearCount(battingHistory.getAppear())
                .hitCount(battingHistory.getHits())
                .outCount(battingHistory.getOut())
                .hitRatio(battingHistory.getHitRatio())
                .playing(battingHistory.getBatterUniformNumber() == playingUniformNumber)
                .build();
    }
}
