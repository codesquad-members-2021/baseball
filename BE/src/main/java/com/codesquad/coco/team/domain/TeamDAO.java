package com.codesquad.coco.team.domain;

import com.codesquad.coco.team.domain.DTO.MainPageTeamDTO;
import com.codesquad.coco.team.domain.DTO.TeamNameDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class TeamDAO {

    private JdbcTemplate template;

    public TeamDAO(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public MainPageTeamDTO findAllName() {
        String sql = "select t.name from team t;";

        MainPageTeamDTO mainPageTeamDTO = new MainPageTeamDTO();

        template.query(sql, (rs, rowNum) -> {
            mainPageTeamDTO.addTeamDTO(new TeamNameDTO(
                    rs.getString("name")
            ));
            return null;
        });
        return mainPageTeamDTO;
    }
}
