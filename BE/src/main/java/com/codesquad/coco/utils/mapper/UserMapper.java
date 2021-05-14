package com.codesquad.coco.utils.mapper;

import com.codesquad.coco.user.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User.Builder()
                .id(rs.getLong("id"))
                .githubId(rs.getLong("github_id"))
                .login(rs.getString("login"))
                .htmlUrl(rs.getString("html_url"))
                .location(rs.getString("location"))
                .followers(rs.getInt("followers"))
                .following(rs.getInt("following"))
                .accessToken(rs.getString("access_token"))
                .refreshToken(rs.getString("refresh_token"))
                .builder();
    }
}
