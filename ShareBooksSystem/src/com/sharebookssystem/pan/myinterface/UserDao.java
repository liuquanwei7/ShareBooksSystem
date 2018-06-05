package com.sharebookssystem.pan.myinterface;

import com.sharebookssystem.model.User;

import java.util.List;

public interface UserDao {
    public List queryUserByN_I_P(User user, int page);
    public int updateByUser(User user);
    public int saveByUser(User user);
}
