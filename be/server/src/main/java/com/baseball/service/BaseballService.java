package com.baseball.service;

import com.baseball.dto.GameInfoDto;
import com.baseball.dto.MatchDto;
import com.baseball.dto.MatchInfoDto;
import com.baseball.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaseballService {
    private final BaseballRepository baseballRepository;
    private final MatchInfoRepository matchInfoRepository;
    private final GameInfoRepository gameInfoRepository;

    // FIXME: 나중에 JDBC 연결을 하면 이 생성자는 삭제해야함
    public BaseballService() {
        this(new MockedBaseballRepository(), new MockedMatchInfoRepository(), new MockedGameInfoRepository());
    }

    public BaseballService(BaseballRepository baseballRepository, MatchInfoRepository matchInfoRepository, GameInfoRepository gameInfoRepository) {
        this.baseballRepository = baseballRepository;
        this.matchInfoRepository = matchInfoRepository;
        this.gameInfoRepository = gameInfoRepository;
    }

    public List<MatchDto> getMatches() {
        return baseballRepository.findAllMatches().entrySet().stream()
                .map(MatchDto::from)
                .collect(Collectors.toList());
    }

    public MatchInfoDto getProgress(String gameId, String teamId) {
        return MatchInfoDto.from(matchInfoRepository.findByGameId(gameId));
    }

    public GameInfoDto getGameInfo(String gameId, String teamId) {
        return GameInfoDto.from(gameInfoRepository.findByGameId(gameId));
    }

    public void playGame(String gameId, String inningResult) {
        /**
         * TODO: inningResult 는 ball, hit, strike 중 1개의 String 이다.
         * 만약 3개에 해당되지 않는 string 이나, 비어있는 String 을 받았다면,
         * 랜덤하게 3개중에 한개를 생성하도록 한다.
         */
    }

}
