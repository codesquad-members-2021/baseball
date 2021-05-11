package com.dong.baseball.Controller;

import com.dong.baseball.DTO.MatchUpListDTO;
import com.dong.baseball.DTO.ProgressDTO;
import com.dong.baseball.DTO.SituationBoardDTO;
import com.dong.baseball.Domain.Board;
import com.dong.baseball.Domain.Match;
import com.dong.baseball.Service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {


    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("")
    public List<MatchUpListDTO> allMatches() {
        return gameService.matchList();
    }

    @GetMapping("/{matchId}")
    public List<SituationBoardDTO> matchInfos(@PathVariable Long matchId) {
        return gameService.matchInformations(matchId);
    }

    @GetMapping("/progress/offense")
    public ProgressDTO offeseInfo() {
        return new ProgressDTO("");
    }

    @GetMapping("/progress/defense")
    public ProgressDTO defenseInfo() {
        return new ProgressDTO("");
    }


}
