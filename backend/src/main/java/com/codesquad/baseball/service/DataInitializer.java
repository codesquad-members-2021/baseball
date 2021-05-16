package com.codesquad.baseball.service;

import com.codesquad.baseball.domain.game.Game;
import com.codesquad.baseball.domain.team.Team;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DataInitializer {

    private static final String SAMPLE_GAME_TITLE_FORMAT = "GAME-%d";
    private final TeamService teamService;
    private final GameService gameService;
    private final TestDataLoader testDataLoader;

    public DataInitializer(TeamService teamService, GameService gameService, TestDataLoader testDataLoader) {
        this.teamService = teamService;
        this.gameService = gameService;
        this.testDataLoader = testDataLoader;
    }

    public void reset() {
        teamService.removeAll();
        gameService.removeAll();
        initialize();
    }

    public void initialize() {
        HashMap<String, List<String>> testDataDTO = testDataLoader.loadTestData();
        List<Team> teams = createTeams(testDataDTO);
        List<Game> games = IntStream.range(1, 10)
                .mapToObj(gameIndex -> createGame(teams, gameIndex))
                .collect(Collectors.toList());
    }

    private List<Team> createTeams(HashMap<String, List<String>> testDataDTO) {
        return testDataDTO
                .keySet()
                .stream()
                .map(teamService::createTeam)
                .peek(team -> registerPlayers(team, testDataDTO))
                .collect(Collectors.toList());
    }

    private void registerPlayers(Team team, HashMap<String, List<String>> testDataDTO) {
        List<String> playerNames = testDataDTO.get(team.getTeamName());
        IntStream.range(0, playerNames.size() - 1).forEach(playerIndex -> {
            teamService.addHitter(team, playerNames.get(playerIndex), playerIndex + 1);
        });
        teamService.addPitcher(team, playerNames.get(playerNames.size() - 1), playerNames.size());
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
