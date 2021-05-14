package com.team22.baseball.service;

import com.team22.baseball.domain.Game;
import com.team22.baseball.domain.Player;
import com.team22.baseball.domain.Team;
import com.team22.baseball.domain.TeamScore;
import com.team22.baseball.dto.request.UpdatePlayerInfo;
import com.team22.baseball.dto.response.DetailScore.DetailScore;
import com.team22.baseball.dto.response.GameList.GameList;
import com.team22.baseball.dto.response.PlayerScoreList.PlayerInfo;
import com.team22.baseball.dto.response.PlayerScoreList.ScoreList;
import com.team22.baseball.dto.response.PlayerScoreList.TeamInfo;
import com.team22.baseball.dto.response.TeamSelect.*;
import com.team22.baseball.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameList> findAllGame() {
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

    public void updatePlayerInfo(String name, int plate_appearance, int hits, int outs) {
        gameRepository.updatePlayerInfo(name, plate_appearance, hits, outs);
    }

    public void insertTeamScore(String teamName, int round, int score) {
        gameRepository.insertTeamScore(teamName, round, score);
    }

    public Player findPlayerByName(String name) throws Exception {
        return gameRepository.findPlayerByName(name).orElseThrow(Exception::new);
    }

    public int[] calculatePlayerScore(UpdatePlayerInfo req) throws Exception {

        Player findPlayer = findPlayerByName(req.getPlayerName());

        int plateAppearance = findPlayer.getPlateAppearance() + 1; //m 타석은 무조건 1이 맞을까 ?
        int hits;
        int outs;

        if (req.isHit()) {
            hits = findPlayer.getHits() + 1;
            outs = findPlayer.getOuts();
        } else {
            outs = findPlayer.getOuts() + 1;
            hits = findPlayer.getHits();
        }

        return new int[]{plateAppearance, hits, outs};

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

        boolean gameStatus = true; //TODO. 나중에 검증 로직 만들기

        gameRepository.updateGameStatusByTitle(teamTitle, gameStatus);
        gameRepository.updateSelectedTeamByTitle(teamTitle, gameStatus);

    }

    public Game findGameById(Long gameId) throws Exception {
        return gameRepository.findGameById(gameId).orElseThrow(Exception::new);
    }

    public NextPlayerInfoDto findNextPlayerByNumberAndTeamName(int nextUniformNumber, String teamName) throws Exception {
        return gameRepository.findNextPlayerByNumberAndTeamName(nextUniformNumber,teamName).orElseThrow(Exception::new);
    }

    public List<ScoreList> getPlayerScoreOfGame(Game findGame){

        List<ScoreList> responseDto = new ArrayList<>();

        for (Team team : findGame.getTeams()) {

            List<PlayerInfo> playerInfos = new ArrayList<>();
            TeamInfo teamInfo = TeamInfo.of(team.getName(), team.isHome(), team.isSelected());

            for (Player player : team.getPlayers()) {
                playerInfos.add(PlayerInfo.of(player.getUniformNumber(), player.getName(), player.getPlateAppearance(), player.getHits(), player.getOuts()));
            }
            responseDto.add(ScoreList.of(teamInfo, playerInfos));
        }

        return responseDto;

    }

    public NextPlayerInfoDto updatePlayerInfo(UpdatePlayerInfo req) throws Exception {
        int[] scores = calculatePlayerScore(req);

        updatePlayerInfo(req.getPlayerName(), scores[0], scores[1], scores[2]);
        insertTeamScore(req.getTeamName(), req.getRound(), req.getTeamScore());

        Player prevPlayer = findPlayerByName(req.getPlayerName());

        int prevUniformNumber = prevPlayer.getUniformNumber();
        String teamName = req.getTeamName();

        int nextUniformNumber = ++prevUniformNumber > 10 ? 1 : prevUniformNumber;

        return findNextPlayerByNumberAndTeamName(nextUniformNumber, teamName);
    }

    public void resetGameData(Long gameId) {
        List<Team> teams = gameRepository.findTeamById(gameId);

        for(Team team : teams){
            gameRepository.resetTeamScore(team.getId());
            gameRepository.resetPlayer(team.getId());
        }
        gameRepository.resetTeam(gameId);
        gameRepository.resetGame(gameId);
    }
}
