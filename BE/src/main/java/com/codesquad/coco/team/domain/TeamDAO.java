package com.codesquad.coco.team.domain;

import com.codesquad.coco.team.domain.DTO.MainPageTeamDTO;
import com.codesquad.coco.team.domain.DTO.TeamNameDTO;
import com.codesquad.coco.utils.mapper.TeamNameMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.codesquad.coco.utils.SQL.FIND_ALL_TEAM_NAME;

@Component
public class TeamDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private TeamNameMapper mapper = new TeamNameMapper();

    public TeamDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public MainPageTeamDTO findAllName() {
        MainPageTeamDTO mainPageTeamDTO = new MainPageTeamDTO();
        List<TeamNameDTO> query = namedParameterJdbcTemplate.query(FIND_ALL_TEAM_NAME, mapper);
        query.forEach(mainPageTeamDTO::addTeamDTO);
        return mainPageTeamDTO;
    }
}
