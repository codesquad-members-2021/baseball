package com.baseball.service;

import com.baseball.dto.GameInfoDto;
import com.baseball.dto.MatchDto;
import com.baseball.dto.MatchInfoDto;
import com.baseball.repository.BaseballRepository;
import com.baseball.repository.MockedBaseballRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaseballService {
    private final BaseballRepository baseballRepository;

    // FIXME: 나중에 JDBC 연결을 하면 이 생성자는 삭제해야함
    public BaseballService() {
        this(new MockedBaseballRepository());
    }

    public BaseballService(BaseballRepository baseballRepository) {
        this.baseballRepository = baseballRepository;
    }

    public List<MatchDto> getMatches() {
        return baseballRepository.findAllMatches().entrySet().stream()
                .map(MatchDto::from)
                .collect(Collectors.toList());
    }

    public MatchInfoDto getProgress(String matchId) {
        return MatchInfoDto.from(baseballRepository.findMatchById(matchId));
    }

    public GameInfoDto getGameInfo(String matchId) {
        return GameInfoDto.from(baseballRepository.findMatchById(matchId));
    }

    public void selectTeam(String matchId, String teamName) {
        baseballRepository.findMatchById(matchId)
                .selectTeam(teamName);
    }

    public void playGame(String matchId, String pitchResult) {
        baseballRepository.findMatchById(matchId)
                .play(pitchResult);
    }

}
