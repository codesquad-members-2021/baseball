package com.codesquad.baseball.service;

import com.codesquad.baseball.domain.*;
import com.codesquad.baseball.dto.*;
import com.codesquad.baseball.exceptions.GameAlreadyOccupiedException;
import com.codesquad.baseball.exceptions.GameNotFoundException;
import com.codesquad.baseball.exceptions.PlayerNotFoundException;
import com.codesquad.baseball.utils.PitchRandomTable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final TeamService teamService;

    public GameService(GameRepository gameRepository, PlayerRepository playerRepository, TeamService teamService) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.teamService = teamService;
    }

    @Transactional(readOnly = true)
    public GamesDTO showGames() {
        Iterable<Game> games = gameRepository.findAll();
        List<GameDTO> gameDTOS = StreamSupport.stream(games.spliterator(), false)
                .map(game -> {
                    Team homeTeam = teamService.findTeam(game.homeTeamId());
                    Team awayTeam = teamService.findTeam(game.awayTeamId());
                    return GameDTO.from(game, homeTeam, awayTeam);
                }).collect(Collectors.toList());
        return new GamesDTO(gameDTOS);
    }

    @Transactional
    public void joinIn(int gameId) {
        Game game = findGame(gameId);
        if (game.isOccupied()) {
            throw new GameAlreadyOccupiedException(gameId);
        }
        game.joinGame();
        gameRepository.save(game);
    }

    @Transactional(readOnly = true)
    public GameDetailDTO gameDetail(int gameId) {
        Game game = findGame(gameId);
        TeamDetailDTO homeTeamDetail = teamDetailDTO(game, TeamType.HOME);
        TeamDetailDTO awayTeamDetail = teamDetailDTO(game, TeamType.AWAY);
        return GameDetailDTO.from(homeTeamDetail, awayTeamDetail, game);
    }


    @Transactional
    public Game createGame(String gameTitle, Team teamA, Team teamB) {
        TeamParticipatingInGame aTeamParticipant = teamA.createParticipantAsHomeTeam();
        TeamParticipatingInGame bTeamParticipant = teamB.createParticipantAsAwayTeam();

        registerPlayersInGame(teamA, aTeamParticipant);
        registerPlayersInGame(teamB, bTeamParticipant);

        Game game = Game.createGame(gameTitle, aTeamParticipant, bTeamParticipant);
        game.initializeGame();
        return gameRepository.save(game);
    }

    @Transactional
    public PitchDTO doPitch(int gameId) {
        Game game = findGame(gameId);
        PitchResult pitchResult = game.pitch(PitchRandomTable.rollDice());
        gameRepository.save(game);
        return createPitchDTO(game, pitchResult);
    }

    private PitchDTO createPitchDTO(Game game, PitchResult pitchResult) {
        TeamDetailDTO homeTeam = teamDetailDTO(game, TeamType.HOME);
        TeamDetailDTO awayTeam = teamDetailDTO(game, TeamType.AWAY);
        GameStatusDTO gameStatusDTO = GameStatusDTO.from(game);
        GameScoreDTO gameScoreDTO = GameScoreDTO.from(game);
        PitchResultDTO pitchResultDTO = PitchResultDTO.from(pitchResult, game);

        return new PitchDTO(homeTeam, awayTeam, gameStatusDTO, gameScoreDTO, pitchResultDTO);
    }

    private Game findGame(int gameId) {
        return gameRepository.findById(gameId).orElseThrow(() -> new GameNotFoundException(gameId));
    }

    private TeamDetailDTO teamDetailDTO(Game game, TeamType teamType) {
        if (teamType == TeamType.HOME) {
            return teamDetailDTO(game.homeTeam());
        } else {
            return teamDetailDTO(game.awayTeam());
        }
    }

    private TeamDetailDTO teamDetailDTO(TeamParticipatingInGame teamParticipant) {
        Team team = teamService.findTeam(teamParticipant.getTeam());
        List<PlayerDTO> players = playerDTOsByTeamParticipant(teamParticipant);
        return TeamDetailDTO.from(team, players);
    }

    private List<PlayerDTO> playerDTOsByTeamParticipant(TeamParticipatingInGame participant) {
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        for (PlayerParticipatingInGame playerParticipant : participant.getPlayers()) {
            Player player = playerRepository.findById(playerParticipant.getPlayer())
                    .orElseThrow(() -> new PlayerNotFoundException(PlayerNotFoundException.FIND_PLAYER_FAILED));
            playerDTOS.add(PlayerDTO.from(player, playerParticipant));
        }
        return playerDTOS;
    }

    private void registerPlayersInGame(Team team, TeamParticipatingInGame teamParticipant) {
        team.getPlayers().stream()
                .filter(Player::isHitter)
                .forEach(teamParticipant::addPlayer);
        Player pitcher = team.getPlayers()
                .stream()
                .filter(Player::isPitcher)
                .findFirst()
                .orElseThrow(() -> new PlayerNotFoundException(PlayerNotFoundException.FIND_PITCHER_FAILED));
        teamParticipant.addPlayer(pitcher, PitcherPosition.SP);
    }
}
