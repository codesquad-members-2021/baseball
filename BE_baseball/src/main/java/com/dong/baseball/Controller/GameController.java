package com.dong.baseball.Controller;

import com.dong.baseball.DTO.BaseballServerResponseDTO;
import com.dong.baseball.DTO.MatchAllProgressDataDTO;
import com.dong.baseball.DTO.MatchUpListsDTO;
import com.dong.baseball.DTO.ProgressDTO;
import com.dong.baseball.Service.GameService;
import org.springframework.web.bind.annotation.*;

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
    public MatchAllProgressDataDTO matchInfos(@PathVariable Long matchId) {
        return new MatchAllProgressDataDTO(gameService.findMatch(matchId), gameService.matchInformations(matchId));
    }

    @GetMapping("/{matchId}/offense")
    public ProgressDTO offeseInfo(@PathVariable Long matchId) {
        gameService.matchInformations(matchId);
        return new ProgressDTO(gameService.matchStream(matchId));
    }

    @GetMapping("/{matchId}/defense")
    public ProgressDTO defenseInfo(@PathVariable Long matchId) {

        gameService.matchInformations(matchId);
        return new ProgressDTO(gameService.matchStream(matchId));
    }

    @PostMapping("/{matchId}/start")
    public BaseballServerResponseDTO gameStart(@PathVariable Long matchId) {
        return gameService.gameStart(matchId);
    }

    @PostMapping("/{matchId}/end")
    public BaseballServerResponseDTO gameEnd(@PathVariable Long matchId) {
        return gameService.gameEnd(matchId);
    }

    @PostMapping("/{matchId}/throws")
    public BaseballServerResponseDTO gameProgress(@PathVariable Long matchId) {
        return gameService.gameProgress(matchId);
    }
}
