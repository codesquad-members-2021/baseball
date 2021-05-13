package baseball.controller;

import baseball.service.GameService;
import baseball.service.dto.GameDTO;
import baseball.service.dto.GameMemberDTO;
import baseball.service.dto.GameScoreDTO;
import baseball.service.dto.RequestScoreDTO;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameDTO> showGames() {
        return gameService.getGameDTOList();
    }

    @PostMapping("/{teamId}/score")
    public void saveScore(@PathVariable Long teamId, @RequestBody RequestScoreDTO scoreDTO) {
        gameService.saveScore(teamId, scoreDTO.getInningNumber(), scoreDTO.getScore());
    }

    @GetMapping("/{gameId}/scores")
    public GameScoreDTO showScore(@PathVariable Long gameId) {
        return gameService.convertToGameScoreDTO(gameId);
    }

    @GetMapping("/{gameId}/members")
    public GameMemberDTO showMembers(@PathVariable Long gameId) {
        return gameService.getGameMemberDTO(gameId);
    }
}
