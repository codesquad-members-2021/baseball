package baseball.controller;

import baseball.service.GameService;
import baseball.service.dto.GameDTO;
import baseball.service.dto.GameTeamDTO;
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

    @PostMapping("/{gameId}/{teamId}/score")
    public void saveScore(@PathVariable Long gameId, @PathVariable Long teamId, @RequestBody ScoreRequest scoreRequest) {
        gameService.saveScore(gameId, teamId, scoreRequest);
    }

    @GetMapping("/{gameId}/scores")
    public GameScoreDTO showScore(@PathVariable Long gameId) {
        return gameService.getGameScoreDTO(gameId);
    }

    @GetMapping("/{gameId}/records")
    public GameTeamDTO showRecordsByGame(@PathVariable Long gameId) {
        return gameService.getGameTeamDTO(gameId);
    }

    @DeleteMapping
    public void deleteGame() {
        gameService.deleteGame();
    }
}
