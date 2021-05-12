package com.codesquad.baseball.service;

import com.codesquad.baseball.domain.game.Game;
import com.codesquad.baseball.domain.team.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DataInitializer {

    private static final String SAMPLE_TEAM_NAME_FORMAT = "TEAM-%d";
    private static final String SAMPLE_HITTER_NAME_FORMAT = "TEAM-%d-HITTER-%d";
    private static final String SAMPLE_PITCHER_NAME_FORMAT = "TEAM-%d-PITCHER-%d";
    private static final String SAMPLE_GAME_TITLE_FORMAT = "GAME-%d";
    private final TeamService teamService;
    private final GameService gameService;

    public DataInitializer(TeamService teamService, GameService gameService) {
        this.teamService = teamService;
        this.gameService = gameService;
    }

    public void reset() {
        teamService.removeAll();
        gameService.removeAll();
        initialize();
    }

    public void initialize() {
        //9개 팀 생성
        List<Team> teams = IntStream.range(1, 10)
                .mapToObj(this::createTeam)
                .collect(Collectors.toList());
        //게임 생성
        List<Game> games = IntStream.range(1, 10)
                .mapToObj(gameIndex -> createGame(teams, gameIndex))
                .collect(Collectors.toList());
    }

    private Team createTeam(int teamIndex) {
        Team team = teamService.createTeam(String.format(SAMPLE_TEAM_NAME_FORMAT, teamIndex));
        IntStream.range(0, 8).forEach(playerIndex -> {
            String currentPlayerName = String.format(SAMPLE_HITTER_NAME_FORMAT, teamIndex, playerIndex);
            teamService.addHitter(team, currentPlayerName, playerIndex);
        });
        teamService.addPitcher(team, String.format(SAMPLE_PITCHER_NAME_FORMAT, teamIndex, 9), 9);
        return team;
    }

    private Game createGame(List<Team> teams, int gameIndex) {
        String gameTitle = String.format(SAMPLE_GAME_TITLE_FORMAT, gameIndex);
        Team teamA = randomTeam(teams);
        Team teamB = randomTeam(teams);
        return gameService.createGame(gameTitle, teamA, teamB);
    }

    private Team randomTeam(List<Team> teams) {
        int randomIndex = (int) (Math.random() * (teams.size()));
        return teams.get(randomIndex);
    }
}
