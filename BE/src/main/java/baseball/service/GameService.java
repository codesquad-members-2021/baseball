package baseball.service;

import baseball.domain.*;
import baseball.exception.GameNotFoundException;
import baseball.exception.TeamNotFoundException;
import baseball.repository.GameRepository;
import baseball.repository.TeamRepository;
import baseball.service.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private static final int NUMBER_OF_TEAM = 10;
    private static final int EMPTY = 0;

    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;

    public GameService(GameRepository gameRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
    }

    public GameDTO getGameDTO() {
        if (gameRepository.count() == EMPTY) {
            saveGames();
        }
        List<Game> games = gameRepository.findAll();

        return new GameDTO(games);
    }

    private void saveGames() {
        List<Game> games = new ArrayList<>();

        long id = 1;
        for (long i = 1; i <= NUMBER_OF_TEAM; i += 2) {
            Team homeTeam = findTeamById(i);
            Team awayTeam = findTeamById(i + 1);

            Game game = new Game(id, homeTeam.getId(), awayTeam.getId());
            games.add(game);
            id++;
        }
        gameRepository.saveAll(games);
    }

    public void saveScore(Long gameId, Long teamId, ScoreRequest scoreRequest) {
        Game game = findGameById(gameId);
        Team team = findTeamById(teamId);

        if (!game.isTeamInGame(team)) {
            throw new TeamNotFoundException();
        }
        Score newScore = scoreRequest.toScore();
        team.addScore(newScore);

        teamRepository.save(team);
    }

    public GameScoreDTO getGameScoreDTO(Long gameId) {
        Game game = findGameById(gameId);
        Team homeTeam = findTeamById(game.getHomeTeamId());
        Team awayTeam = findTeamById(game.getAwayTeamId());

        return new GameScoreDTO(game, homeTeam, awayTeam);
    }

    public GameTeamDTO getGameTeamDTO(Long gameId) {
        Game game = findGameById(gameId);
        Team homeTeam = findTeamById(game.getHomeTeamId());
        Team awayTeam = findTeamById(game.getAwayTeamId());

        List<RecordDTO> homeRecordDTOs = getRecordDTOList(homeTeam);
        List<RecordDTO> awayRecordDTOs = getRecordDTOList(awayTeam);

        return new GameTeamDTO(gameId, homeRecordDTOs, awayRecordDTOs);
    }

    public void deleteGame() {
        gameRepository.deleteAll();

        List<Team> teams = teamRepository.findAll().stream()
                .map(team -> {
                    team.deleteScores();
                    team.deleteRecordOfMembers();
                    return team;
                }).collect(Collectors.toList());

        teamRepository.saveAll(teams);
    }

    private Game findGameById(Long id) {
        return gameRepository.findById(id).orElseThrow(GameNotFoundException::new);
    }

    private Team findTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow(TeamNotFoundException::new);
    }

    private List<RecordDTO> getRecordDTOList(Team team) {
        return team.getMembers().stream()
                .filter(Member::hasRecord)
                .map(member -> {
                    Record record = member.getRecord();
                    return RecordDTO.toRecordDTO(member, record);
                })
                .collect(Collectors.toList());
    }
}
