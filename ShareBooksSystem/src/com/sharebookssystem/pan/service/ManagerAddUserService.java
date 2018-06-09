package com.sharebookssystem.pan.service;

import com.sharebookssystem.model.User;
import com.sharebookssystem.pan.myinterface.UserDao;
import com.sharebookssystem.pan.myinterface.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("managerAddUserService")
public class ManagerAddUserService implements UserService {
    @Resource(name = "userDaoImpl")
    private UserDao userDao;

    @Override
    public boolean service(User user) {
        if (userDao.saveByUser(user) != 0) return true;
        else return false;
    }

    @Override
    public List service(User user, int page) {
        return null;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
