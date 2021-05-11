package com.codesquad.baseball.service;

import com.codesquad.baseball.domain.*;
import com.codesquad.baseball.exceptions.PlayerNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
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
