package com.team22.baseball.service;

import com.team22.baseball.domain.Game;
import com.team22.baseball.domain.Player;
import com.team22.baseball.domain.Team;
import com.team22.baseball.domain.TeamScore;
import com.team22.baseball.dto.request.UpdatePlayerInfo;
import com.team22.baseball.dto.response.DetailScore.DetailScore;
import com.team22.baseball.dto.response.GameList.GameInfo;
import com.team22.baseball.dto.response.PlayerScoreList.PlayerInfo;
import com.team22.baseball.dto.response.PlayerScoreList.ScoreList;
import com.team22.baseball.dto.response.PlayerScoreList.TeamInfo;
import com.team22.baseball.dto.response.TeamSelect.*;
import com.team22.baseball.exception.NotFoundException;
import com.team22.baseball.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private static final int ONE = 1;

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameInfo> findAllGame() {
        return gameRepository.findAllGame();
    }

    public List<TeamTypeDto> findTeamListByTeamTitle(String title) {
        return gameRepository.findTeamListByTeamTitle(title);
    }

    public TeamInfoDto findTeamInfoByTitle(String title) throws Exception {
        return gameRepository.findTeamInfoByTitle(title).orElseThrow(Exception::new);
    }

    public List<PlayerInfoDto> findPlayerListByTeamTitle(String title) {
        return gameRepository.findPlayerListByTeamTitle(title);
    }


    public List<TeamListDto> getInfoSelectedTeam(String title) throws Exception {
        List<TeamListDto> teamListDtos = new ArrayList<>();
        List<TeamTypeDto> teamTypeDtoList = findTeamListByTeamTitle(title);

        for (TeamTypeDto type : teamTypeDtoList) {
            String teamTitle = type.getName();
            TeamInfoDto teamInfoDto = findTeamInfoByTitle(teamTitle);
            List<PlayerInfoDto> playerInfoDto = findPlayerListByTeamTitle(teamTitle);

            teamListDtos.add(new TeamListDto(teamInfoDto, playerInfoDto));
        }

        return teamListDtos;
    }

    public void updatePlayerInfo(String name, int plateAppearance, int hits, int outs) {
        gameRepository.updatePlayerInfo(name, plateAppearance, hits, outs);
    }

    public void insertTeamScore(String teamName, int round, int score) {
        gameRepository.insertTeamScore(teamName, round, score);
    }

    public Player findPlayerByName(String name) {
        return gameRepository.findPlayerByName(name).orElseThrow(NotFoundException::new);
    }

    public List<Integer> calculatePlayerScore(UpdatePlayerInfo updatePlayerInfo) {

        Player findPlayer = findPlayerByName(updatePlayerInfo.getPlayerName());
        List<Integer> scores = new ArrayList<>();

        int hits = findPlayer.getHits();
        int outs = findPlayer.getOuts() + ONE;

        if (updatePlayerInfo.isHit()) {
            hits = findPlayer.getHits() + ONE;
            outs = outs - ONE;
        }

        scores.add(findPlayer.getPlateAppearance() + ONE);
        scores.add(hits);
        scores.add(outs);

        return scores;

    }

    public List<Team> findTeamById(Long id) {
        return gameRepository.findTeamById(id);
    }

    public List<TeamScore> findTeamScoreByName(String name) {
        return gameRepository.findTeamScoreByName(name);
    }

    public List<DetailScore> getDetailScoreOfEachTeam(Long gameID) {

        List<Team> teams = findTeamById(gameID);

        List<DetailScore> detailScores = new ArrayList<>();

        for (Team team : teams) {
            detailScores.add(new DetailScore(team.getName(), findTeamScoreByName(team.getName())));
        }

        return detailScores;
    }

    public void updateGameStatusByTitle(String teamTitle) {

        boolean gameStatus = true;

        gameRepository.updateGameStatusByTitle(teamTitle, gameStatus);
        gameRepository.updateSelectedTeamByTitle(teamTitle, gameStatus);

    }

    public Game findGameById(Long gameId) throws Exception {
        return gameRepository.findGameById(gameId).orElseThrow(Exception::new);
    }

    public NextPlayerInfoDto findNextPlayerByNumberAndTeamName(int nextUniformNumber, String teamName) {
        return gameRepository.findNextPlayerByNumberAndTeamName(nextUniformNumber, teamName).orElseThrow(NotFoundException::new);
    }

    public List<ScoreList> getPlayerScoreOfGame(Long gameId) {

        List<ScoreList> responseDto = new ArrayList<>();
        Game findGame = gameRepository.findGameById(gameId).orElseThrow(NotFoundException::new);

        for (Team team : findGame.getTeams()) {

            List<PlayerInfo> playerInfos = new ArrayList<>();
            TeamInfo teamInfo = TeamInfo.of(team.getName(), team.isHome(), team.isSelected());

            for (Player player : team.getPlayers()) {
                playerInfos.add(new PlayerInfo(player));
            }
            responseDto.add(ScoreList.of(teamInfo, playerInfos));
        }

        return responseDto;

    }

    public NextPlayerInfoDto updatePlayerInfo(UpdatePlayerInfo updatePlayerInfo) {

        List<Integer> scores = calculatePlayerScore(updatePlayerInfo);

        final int PLATE_APPEARANCE = 0;
        final int HITS = 1;
        final int OUTS = 2;

        final int MAX_PLAYER = 10;

        updatePlayerInfo(updatePlayerInfo.getPlayerName(), scores.get(PLATE_APPEARANCE), scores.get(HITS), scores.get(OUTS));
        insertTeamScore(updatePlayerInfo.getTeamName(), updatePlayerInfo.getRound(), updatePlayerInfo.getTeamScore());

        Player prevPlayer = findPlayerByName(updatePlayerInfo.getPlayerName());

        int prevUniformNumber = prevPlayer.getUniformNumber();
        String teamName = updatePlayerInfo.getTeamName();

        int nextUniformNumber = ++prevUniformNumber > MAX_PLAYER ? ONE : prevUniformNumber;

        return findNextPlayerByNumberAndTeamName(nextUniformNumber, teamName);
    }

    public void resetGameData(Long gameId) {
        List<Team> teams = gameRepository.findTeamById(gameId);

        for (Team team : teams) {
            gameRepository.resetTeamScore(team.getId());
            gameRepository.resetPlayer(team.getId());
        }
        gameRepository.resetTeam(gameId);
        gameRepository.resetGame(gameId);
    }
}
