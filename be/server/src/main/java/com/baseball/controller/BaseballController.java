package com.baseball.controller;

import com.baseball.dto.GameInfoDto;
import com.baseball.dto.MatchDto;
import com.baseball.dto.MatchInfoDto;
import com.baseball.service.BaseballService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BaseballController {

    private final BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    @GetMapping("/match")
    public ResponseEntity<List<MatchDto>> getMatch() {
        List<MatchDto> matches = baseballService.getMatches();
        return ResponseEntity.ok().body(matches);
    }

    @GetMapping("/progress/{id}")
    public ResponseEntity<MatchInfoDto> getProgress(@PathVariable String id) {
        MatchInfoDto matchInfo = baseballService.getProgress(id);
        return ResponseEntity.ok().body(matchInfo);
    }

    @GetMapping("/gameInfo/{id}")
    public ResponseEntity<GameInfoDto> getGameInfo(@PathVariable String id) {
        GameInfoDto gameInfo = baseballService.getGameInfo(id);
        return ResponseEntity.ok().body(gameInfo);
    }
}
