package com.dong.baseball.Controller;

import com.dong.baseball.DTO.MatchUpListDTO;
import com.dong.baseball.DTO.ProgressDTO;
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
    public List<ProgressDTO> matchInfos(@PathVariable Long matchId) {
        return gameService.matchInformations(matchId);
    }

    @GetMapping("/offense/{matchId}")
    public ProgressDTO offeseInfo(@PathVariable Long matchId) {

        gameService.matchInformations(matchId);
        return new ProgressDTO(gameService.matchStream(matchId));
    }

    @GetMapping("/defense/{matchId}")
    public ProgressDTO defenseInfo(@PathVariable Long matchId) {

        gameService.matchInformations(matchId);
        return new ProgressDTO(gameService.matchStream(matchId));
    }


}
