package com.sharebookssystem.pan.Service;

import com.sharebookssystem.model.User;
import com.sharebookssystem.pan.myinterface.UserDao;
import com.sharebookssystem.pan.myinterface.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userPageService")
public class UserPageService implements UserService {
    @Resource(name = "userDaoImpl")
    private UserDao userDao;

    @Override
    public List service(User user, int page) {
        return userDao.queryUserByN_I_P(user, page);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
