package com.team22.baseball.service;

import com.team22.baseball.dto.response.*;
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

    public List<PlayerInfoDto> findPlayerListByTeamTitle(String title){
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

    public void updateSelectedTeamByTitle(String title) {
        gameRepository.updateSelectedTeamByTitle(title);
    }
}
