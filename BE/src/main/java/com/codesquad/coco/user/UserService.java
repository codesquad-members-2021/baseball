package com.codesquad.coco.user;

import com.codesquad.coco.user.domain.User;
import com.codesquad.coco.user.domain.UserDao;
import com.gitoauth.coco.oauth.AccessToken;
import com.gitoauth.coco.oauth.UserInfoDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insertUser(UserInfoDTO userInfoDTO, AccessToken accessToken) {
        User user = new User.Builder()
                .htmlUrl(userInfoDTO.getHtmlUrl())
                .refreshToken(accessToken.getRefreshToken())
                .accessToken(accessToken.getAccessToken())
                .followers(userInfoDTO.getFollowers())
                .following(userInfoDTO.getFollowing())
                .githubId(userInfoDTO.getId())
                .location(userInfoDTO.getLocation())
                .login(userInfoDTO.getLogin())
                .builder();
        if (userDao.checkNewUser(userInfoDTO.getId())) {
            createUser(user);
            return;
        }
        updateUser(user);
    }

    private void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void createUser(User user) {
        userDao.createUser(user);
    }
}
