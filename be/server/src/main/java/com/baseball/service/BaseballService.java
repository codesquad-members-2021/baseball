package com.baseball.service;

import com.baseball.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BaseballService {

    public List<MatchDto> getMatches() {
        List<MatchDto> matches = new ArrayList<>();
        matches.add(new MatchDto("Captain", "Marble", "U924AX"));
        matches.add(new MatchDto("Honux", "Crong", "H132UY"));
        matches.add(new MatchDto("Android", "Apple", "M887UW"));
        return matches;
    }

    public MatchInfoDto getProgress(String id) {
        ScoreDto score = new ScoreDto(3, 2);
        PitcherDto pitcher = new PitcherDto("김광현", 6, 1, 0, 2);
        BatterDto batter = new BatterDto("류현진", 2, 1, 1, 0.500F);
        MatchInfoDto matchInfo = new MatchInfoDto(score, 2, 3, 1, new Boolean[]{true, true, false}, "3회 말 수비", pitcher, batter, new Boolean[]{true, false, false, true, false});
        return matchInfo;
    }

    public GameInfoDto getGameInfo(String id) {
        ScoreDto score = new ScoreDto(3, 2);
        InningsDto innings = new InningsDto(new Integer[]{1, 1, 1}, new Integer[]{1, 1});

        PlayersDto awayPlayers = new PlayersDto(
                Arrays.asList(new PitcherDto("김광현", 6, 1, 0, 2)),
                Arrays.asList(new BatterDto("류현진", 2, 1, 1, 0.500F))
        );

        PlayersDto homePlayers = new PlayersDto(
                Arrays.asList(new PitcherDto("김광현", 6, 1, 0, 2)),
                Arrays.asList(new BatterDto("류현진", 2, 1, 1, 0.500F))
        );

        GameInfoDto gameInfo = new GameInfoDto(score, innings, awayPlayers, homePlayers);
        return gameInfo;
    }

}
