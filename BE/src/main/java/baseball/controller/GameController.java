package baseball.controller;

import baseball.service.GameService;
import baseball.service.dto.GameDTO;
import baseball.service.dto.GameScoreDTO;
import baseball.service.dto.ScoreRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public GameDTO showGames() {
        return gameService.getGameDTOList();
    }

    @PostMapping("/{teamId}/score")
    public void saveScore(@PathVariable Long teamId, @RequestBody ScoreRequest scoreDTO) {
        gameService.saveScore(teamId, scoreDTO.getInningNumber(), scoreDTO.getScore());
    }

    @GetMapping("/{gameId}/scores")
    public GameScoreDTO showScore(@PathVariable Long gameId) {
        return gameService.convertToGameScoreDTO(gameId);
    }
}
