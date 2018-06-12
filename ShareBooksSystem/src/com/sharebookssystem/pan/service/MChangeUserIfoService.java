package com.sharebookssystem.pan.service;

import com.sharebookssystem.model.User;
import com.sharebookssystem.pan.myinterface.UserDao;
import com.sharebookssystem.pan.myinterface.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("mChangeUserInfoService")
public class MChangeUserIfoService implements UserService {
    @Resource(name = "userDaoImpl")
    UserDao userDao;

    @Override
    public boolean service(User user) {
        if (userDao.updateByUser(user) == 1) return true;
        else return false;
    }

    @Override
    public List service(User user, int page) {
        return null;
    }

    public MChangeUserIfoService() {
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
