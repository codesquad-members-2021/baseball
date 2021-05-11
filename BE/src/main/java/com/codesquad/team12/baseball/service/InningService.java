package com.codesquad.team12.baseball.service;

import com.codesquad.team12.baseball.dto.InningDto;
import com.codesquad.team12.baseball.model.*;
import com.codesquad.team12.baseball.repository.InningRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<InningDto> findAllByTeam(String teamName) {
        return inningRepository
                .findAllByTeam(teamName)
                .stream()
                .map(Inning::createInningDto)
                .collect(Collectors.toList());
    }
}
