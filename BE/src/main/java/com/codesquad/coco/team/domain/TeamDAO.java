package com.codesquad.coco.team.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class TeamDAO {

    private JdbcTemplate template;

    public TeamDAO(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public MainTeamDTO findAllName() {
        String sql = "select t.name from team t;";

        MainTeamDTO mainTeamDTO = new MainTeamDTO();

        template.query(sql, (rs, rowNum) -> {
            mainTeamDTO.addTeamDTO(new TeamDTO(
                    rs.getString("name")
            ));
            return null;
        });
        return mainTeamDTO;
    }
}
