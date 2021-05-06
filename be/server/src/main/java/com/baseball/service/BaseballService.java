package com.baseball.service;

import com.baseball.dto.*;
import com.baseball.repository.MatchRepository;
import com.baseball.repository.MockedMatchRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaseballService {
    private final MatchRepository matchRepository;

    // FIXME: 나중에 JDBC 연결을 하면 이 생성자는 삭제해야함
    public BaseballService() {
        this(new MockedMatchRepository());
    }

    public BaseballService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<MatchDto> getMatches() {
        return matchRepository.findAll().stream()
                .map(MatchDto::from)
                .collect(Collectors.toList());
    }

    public MatchInfoDto getProgress(String id) {
        ScoreDto score = new ScoreDto(3, 2);
        PitcherDto pitcher = new PitcherDto("김광현", 6, 1, 0, 2);
        BatterDto batter = new BatterDto("류현진", 2, 1, 1, 0.500F);
        MatchInfoDto matchInfo = new MatchInfoDto(score, 2, 3, 1, Arrays.asList(true, true, false), "3회 말 수비", pitcher, batter, Arrays.asList(true, false, false, true, false));
        return matchInfo;
    }

    public GameInfoDto getGameInfo(String id) {
        ScoreDto score = new ScoreDto(3, 2);
        InningsDto innings = new InningsDto(Arrays.asList(1, 1, 1), Arrays.asList(1, 1));

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
