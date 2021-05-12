package com.codesquad.coco.user;

import com.codesquad.coco.user.domain.User;
import com.codesquad.coco.user.domain.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User insertUser(Long id) {

        if (userDao.checkNewUser(id)) {
            System.out.println("insert");
        } else {
            System.out.println("update");
        }

        return null;
    }
}
