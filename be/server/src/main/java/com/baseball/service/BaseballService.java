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
    private final MatchRepository matchRepository;
    private final MatchInfoRepository matchInfoRepository;
    private final GameInfoRepository gameInfoRepository;

    // FIXME: 나중에 JDBC 연결을 하면 이 생성자는 삭제해야함
    public BaseballService() {
        this(new MockedMatchRepository(), new MockedMatchInfoRepository(), new MockedGameInfoRepository());
    }

    public BaseballService(MatchRepository matchRepository, MatchInfoRepository matchInfoRepository, GameInfoRepository gameInfoRepository) {
        this.matchRepository = matchRepository;
        this.matchInfoRepository = matchInfoRepository;
        this.gameInfoRepository = gameInfoRepository;
    }

    public List<MatchDto> getMatches() {
        return matchRepository.findAll().stream()
                .map(MatchDto::from)
                .collect(Collectors.toList());
    }

    public MatchInfoDto getProgress(String id) {
        return MatchInfoDto.from(matchInfoRepository.findByGameId(id));
    }

    public GameInfoDto getGameInfo(String id) {
        return GameInfoDto.from(gameInfoRepository.findByGameId(id));
    }

}
