package com.team22.baseball.service;

import com.team22.baseball.domain.Player;
import com.team22.baseball.domain.Team;
import com.team22.baseball.domain.TeamScore;
import com.team22.baseball.dto.request.UpdatePlayerInfoDto;
import com.team22.baseball.dto.response.DetailScore.detailScoreDto;
import com.team22.baseball.dto.response.GameList.GameDto;
import com.team22.baseball.dto.response.TeamSelect.PlayerInfoDto;
import com.team22.baseball.dto.response.TeamSelect.TeamInfoDto;
import com.team22.baseball.dto.response.TeamSelect.TeamListDto;
import com.team22.baseball.dto.response.TeamSelect.TeamTypeDto;
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

    public List<GameDto> findAllGame() {
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

    public int[] calculatePlayerScore(UpdatePlayerInfoDto req) throws Exception {

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

    public List<detailScoreDto> getDetailScoreOfEachTeam(Long gameID) {

        List<Team> teams = findTeamById(gameID);

        List<detailScoreDto> detailScoreDtos = new ArrayList<>();

        for (Team team : teams) {
            detailScoreDtos.add(new detailScoreDto(team.getName(), findTeamScoreByName(team.getName())));
        }

        return detailScoreDtos;
    }

    public void updateGameStatusByTitle(String teamTitle) {

        boolean gameStatus = true; //TODO. 나중에 검증 로직 만들기

        gameRepository.updateGameStatusByTitle(teamTitle, gameStatus);
        gameRepository.updateSelectedTeamByTitle(teamTitle, gameStatus);

    }

}
