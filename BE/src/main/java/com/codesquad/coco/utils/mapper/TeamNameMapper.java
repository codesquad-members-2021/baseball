package com.codesquad.coco.utils.mapper;

import com.codesquad.coco.team.domain.DTO.TeamNameDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamNameMapper implements RowMapper<TeamNameDTO> {
    @Override
    public TeamNameDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TeamNameDTO(rs.getString("name"));
    }
}
