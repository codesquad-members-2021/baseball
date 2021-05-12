package com.codesquad.coco.utils.mapper;

import com.codesquad.coco.user.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getLong("id"),
                rs.getLong("github_id"),
                rs.getString("login"),
                rs.getString("html_url"),
                rs.getString("location"),
                rs.getInt("followers"),
                rs.getInt("following"),
                rs.getString("access_token"),
                rs.getString("refresh_token"));
    }
}
