package com.sharebookssystem.bookUi.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookUi.dao.UserDao;
import com.sharebookssystem.bookUi.utils.MailUitls;
import com.sharebookssystem.model.User;

import java.util.List;
import java.util.Map;

public class userRegisterAction extends ActionSupport {
    User user;
    UserDao ud;
    List<User> users;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDao getUd() {
        return ud;
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String execute() throws Exception{

        String code="王斌大傻子";
        // 发送激活邮件;
        System.out.println("尝试发送");
        MailUitls.sendMail(user.getUserEmail(),code);
        return SUCCESS;
    }

}
