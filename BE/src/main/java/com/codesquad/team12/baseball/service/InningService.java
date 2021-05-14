package com.codesquad.team12.baseball.service;

import com.codesquad.team12.baseball.dto.response.InningDto;
import com.codesquad.team12.baseball.dto.request.InningRequestDto;
import com.codesquad.team12.baseball.model.*;
import com.codesquad.team12.baseball.repository.InningRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InningService {
    private final InningRepository inningRepository;

    public InningService(InningRepository inningRepository) {
        this.inningRepository = inningRepository;
    }

    public void initInning(Long gameId, String teamName) {
        for (int i = 1; i <= 12; i++) {
            Inning inning = new Inning(teamName, i, 0, gameId);
            if (findByTeam(gameId,teamName,i) == null) {
                inningRepository.save(inning);
            }
        }
    }

    public List<InningDto> findAllByTeam(Long gameId, String teamName) {
        return inningRepository
                .findAllByTeam(gameId, teamName)
                .stream()
                .map(Inning::createInningDto)
                .collect(Collectors.toList());
    }

    public void updateInning(Long gameId, InningRequestDto inningRequestDto) {
        System.out.println(inningRequestDto);
        inningRepository.updateInning(gameId, inningRequestDto.getTeamName(), inningRequestDto.getNumber(), inningRequestDto.getScore());
    }

    private Inning findByTeam(Long gameId, String teamName, Integer number) {
        return inningRepository.findByTeam(gameId, teamName, number);
    }
}
