package com.codesquad.team12.baseball.service;

import com.codesquad.team12.baseball.model.Inning;
import com.codesquad.team12.baseball.model.Player;
import com.codesquad.team12.baseball.model.Playing;
import com.codesquad.team12.baseball.model.Team;
import com.codesquad.team12.baseball.repository.InningRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InningService {
    private final InningRepository inningRepository;

    public InningService(InningRepository inningRepository) {
        this.inningRepository = inningRepository;
    }

    public void initInning(Long gameId, String teamName) {
        for (int i = 1; i < 12; i++) {
            Inning inning = new Inning(teamName, i, 0, gameId);
            inningRepository.save(inning);
        }

    }
}
