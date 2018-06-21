package com.sharebookssystem.bookUi.action;
import java.util.Map;
import com.sharebookssystem.model.User;
import com.sharebookssystem.bookUi.dao.UserDao;
import java.lang.String.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import java.io.PrintWriter;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.apache.struts2.*;


public class userLoginAction extends ActionSupport{
    User user;
    UserDao ud=new UserDao();
    List<User> userList;
    public userLoginAction(){}

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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String execute() throws Exception{
        ActionContext ac=ActionContext.getContext();
        //	Map map=ActionContext.getContext().getSession();
        //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
        //拿到表示request对象 的map
        Map<String, Object>  request=ac.getContextMap();
        Map<String, Object> session=ac.getSession();
        session.remove("error");
        ud.queryUserByAccount(user,user.getUserAccount(),user.getUserPassword());
        int userPermission=(int) session.get("userPermission");
        System.out.println(userPermission);
        if(ud.checkLogin(user)&&userPermission>0){
            System.out.println("33333333333333333333333333333333333");
            user=(User)session.get("user");
            System.out.println(user.getUserId());
            return SUCCESS;
        }
        else if(userPermission==0){

            session.put("error","该用户权限不足");
            return INPUT;
        }
        else{
            session.put("error","无此用户");
            return INPUT;
        }
    }
    public void validate(){

        System.out.println("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
//        if(user.getUserAccount()==null||user.getUserAccount().equals("")){
//            addFieldError("user.userAccount","账号不能为空");
//        }
//
//        if(user.getUserPassword()==null || user.getUserPassword().equals("")){
//            addFieldError("user.userPassword","密码不能为空");
//        }
        System.out.println("复查");

        System.out.println(user.getUserPermission());
    }
}
