package com.codesquad.coco.user.domain;

import com.codesquad.coco.utils.mapper.UserCountMapper;
import com.codesquad.coco.utils.mapper.UserMapper;
import com.codesquad.coco.utils.mapper.UserRefreshTokenMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import static com.codesquad.coco.utils.USER_SQLKt.*;

@Component
public class UserDao {

    private NamedParameterJdbcTemplate template;
    private UserMapper userMapper = new UserMapper();
    private UserCountMapper countMapper = new UserCountMapper();
    private UserRefreshTokenMapper tokenMapper = new UserRefreshTokenMapper();

    public UserDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public User findByGitHubId(Long id) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("github_id", id);

        User user = template.queryForObject(FIND_USER_BY_GITHUB_ID, parameter, userMapper);
        return user;
    }

    public boolean checkNewUser(Long id) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("github_id", id);

        Integer count = template.queryForObject(CHEK_NEW_USER_BY_GITHUB_ID, parameter, countMapper);
        return count == 0;
    }

    public void createUser(User user) {
        insertData(CREATE_USER, user);
    }

    public void updateUser(User user) {
        insertData(UPDATE_USER, user);
    }

    private void insertData(String SQL, User user) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("github_id", user.getGithubId());
        parameter.addValue("login", user.getLogin());
        parameter.addValue("html_url", user.getHtmlUrl());
        parameter.addValue("location", user.getLocation());
        parameter.addValue("followers", user.getFollowers());
        parameter.addValue("following", user.getFollowing());
        parameter.addValue("access_token", user.getAccessToken());
        parameter.addValue("refresh_token", user.getRefreshToken());

        template.update(SQL, parameter);
    }

    public String findRefreshTokenByGithubId(Long githubId) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("github_id", githubId);

        return template.queryForObject(FIND_REFRESH_TOKEN_BY_GITHUB_ID, parameter, tokenMapper);

    }

    public void updateTokenByGithubId(String accessToken, String refreshToken, Long githubId) {
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("github_id", githubId);
        parameter.addValue("access_token", accessToken);
        parameter.addValue("refresh_token", refreshToken);

        template.update(UPDATE_TOKEN_BY_GITHUB_ID, parameter);
    }
}
