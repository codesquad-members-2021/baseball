package com.codesquad.baseball.service;

import com.codesquad.baseball.domain.*;
import com.codesquad.baseball.dto.GameDTO;
import com.codesquad.baseball.dto.GamesDTO;
import com.codesquad.baseball.exceptions.PlayerNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final TeamService teamService;

    public GameService(GameRepository gameRepository, TeamService teamService) {
        this.gameRepository = gameRepository;
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
    public Game createGame(String gameTitle, Team teamA, Team teamB) {
        TeamParticipatingInGame aTeamParticipant = teamA.createParticipantAsHomeTeam();
        TeamParticipatingInGame bTeamParticipant = teamB.createParticipantAsAwayTeam();

        teamA.getPlayers().stream().filter(Player::isHitter).forEach(aTeamParticipant::addPlayer);
        teamB.getPlayers().stream().filter(Player::isHitter).forEach(bTeamParticipant::addPlayer);

        registerPlayersInGame(teamA, aTeamParticipant);
        registerPlayersInGame(teamB, bTeamParticipant);

        Game game = Game.createGame(gameTitle, aTeamParticipant, bTeamParticipant);
        game.initializeGame();
        return gameRepository.save(game);
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
