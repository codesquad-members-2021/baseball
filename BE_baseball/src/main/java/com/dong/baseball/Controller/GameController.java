package com.dong.baseball.Controller;

import com.dong.baseball.DTO.MatchUpListsDTO;
import com.dong.baseball.DTO.ProgressDTO;
import com.dong.baseball.DTO.ResponseDTO;
import com.dong.baseball.Service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {


    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("")
    public MatchUpListsDTO allMatches() {
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

    @PostMapping("/start/{matchId}")
    public ResponseDTO gameStart(@PathVariable Long matchId) {
        return gameService.gameStart(matchId);
    }

    @PostMapping("/end/{matchId}")
    public ResponseDTO gameEnd(@PathVariable Long matchId) {
        return gameService.gameEnd(matchId);
    }

    @PostMapping("/throws/{matchId}")
    public ResponseDTO gameProgress(@PathVariable Long matchId) {
        return gameService.gameProgress(matchId);
    }
}
