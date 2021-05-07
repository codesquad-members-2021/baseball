package com.codesquad.coco.team.domain;

import com.codesquad.coco.game.domain.DAO.GameDAO;
import com.codesquad.coco.player.domain.PlayerDAO;
import com.codesquad.coco.team.domain.DTO.MainPageTeamDTO;
import com.codesquad.coco.team.domain.DTO.TeamDTO;
import com.codesquad.coco.team.domain.DTO.TeamNameDTO;
import com.codesquad.coco.utils.DTOConverter;
import com.codesquad.coco.utils.mapper.TeamNameMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.codesquad.coco.utils.SQL.FIND_ALL_TEAM_NAME;

@Component
public class TeamDAO {

    private NamedParameterJdbcTemplate template;
    private PlayerDAO playerDAO;
    private GameDAO gameDAO;
    private TeamNameMapper mapper = new TeamNameMapper();

    public TeamDAO(NamedParameterJdbcTemplate template, PlayerDAO playerDAO, GameDAO gameDAO) {
        this.template = template;
        this.playerDAO = playerDAO;
        this.gameDAO = gameDAO;
    }

    public MainPageTeamDTO findAllName() {
        MainPageTeamDTO mainPageTeamDTO = new MainPageTeamDTO();
        List<TeamNameDTO> query = template.query(FIND_ALL_TEAM_NAME, mapper);
        query.forEach(mainPageTeamDTO::addTeamDTO);
        return mainPageTeamDTO;
    }

    public TeamDTO findHomeTeamByGameId(Long gameId) {
        String teamName = gameDAO.findHomeTeamNameByGameId(gameId);
        Team homeTeam = new Team(teamName, playerDAO.findByTeamName(teamName));
        return DTOConverter.teamToDTO(homeTeam);
    }

    public TeamDTO findAwayTeamByGameId(Long gameId) {
        String teamName = gameDAO.findAwayTeamNameByGameId(gameId);
        Team awayTeam = new Team(teamName, playerDAO.findByTeamName(teamName));
        return DTOConverter.teamToDTO(awayTeam);
    }
}
