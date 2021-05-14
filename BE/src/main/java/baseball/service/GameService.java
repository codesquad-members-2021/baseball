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
import java.util.Set;
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
        Iterable<Game> games = gameRepository.findAll();

        return new GameDTO(games);
    }

    private void saveGames() {
        List<Game> games = new ArrayList<>();

        long id = 1;
        for (long i = 1; i <= NUMBER_OF_TEAM; i += 2) {
            Team homeTeam = teamRepository.findById(i).orElseThrow(TeamNotFoundException::new);
            Team awayTeam = teamRepository.findById(i + 1).orElseThrow(TeamNotFoundException::new);

            Game game = new Game(id, homeTeam.getId(), awayTeam.getId());
            games.add(game);
            id++;
        }
        gameRepository.saveAll(games);
    }

    public void saveScore(Long gameId, Long teamId, ScoreRequest scoreRequest) {
        Game game = gameRepository.findById(gameId).orElseThrow(GameNotFoundException::new);
        Team team = teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);

        if (!game.isTeamInGame(team)) {
            throw new TeamNotFoundException();
        }
        Score newScore = scoreRequest.toScore();
        team.addScore(newScore);

        teamRepository.save(team);
    }

    public GameScoreDTO getGameScoreDTO(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(GameNotFoundException::new);

        Team homeTeam = teamRepository.findById(game.getHomeTeamId()).orElseThrow(TeamNotFoundException::new);
        Team awayTeam = teamRepository.findById(game.getAwayTeamId()).orElseThrow(TeamNotFoundException::new);

        return new GameScoreDTO(game, homeTeam, awayTeam);
    }

    public GameTeamDTO getGameTeamDTO(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(GameNotFoundException::new);
        Team homeTeam = teamRepository.findById(game.getHomeTeamId()).orElseThrow(TeamNotFoundException::new);
        Team awayTeam = teamRepository.findById(game.getAwayTeamId()).orElseThrow(TeamNotFoundException::new);

        List<RecordDTO> homeRecordDTOs = getRecordDTOList(homeTeam);
        List<RecordDTO> awayRecordDTOs = getRecordDTOList(awayTeam);

        return new GameTeamDTO(gameId, homeRecordDTOs, awayRecordDTOs);
    }

    public void deleteGame() {
        gameRepository.deleteAll();

        Iterable<Team> teams = teamRepository.findAll();
        for (Team team : teams) {
            team.deleteScores();
            Set<Member> members = team.getMembers();
            for (Member member : members) {
                member.deleteRecord();
            }
        }
        teamRepository.saveAll(teams);
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
