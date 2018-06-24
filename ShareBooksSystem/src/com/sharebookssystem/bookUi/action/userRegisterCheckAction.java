package com.sharebookssystem.bookUi.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.bookUi.dao.UserDao;
import com.sharebookssystem.model.User;

import java.util.Map;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class userRegisterCheckAction {
    User user;
    UserDao ud;
    String EmailCode;

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

    public String getEmailCode() {
        return EmailCode;
    }

    public void setEmailCode(String emailCode) {
        EmailCode = emailCode;
    }

    public String execute() throws Exception{
        ActionContext ac=ActionContext.getContext();
        //	Map map=ActionContext.getContext().getSession();
        //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
        //拿到表示request对象 的map
        Map<String, Object> request=ac.getContextMap();
        Map<String, Object> session=ac.getSession();
        session.remove("error");
        session.remove("EmailCheckError");
        String code=(String) session.get("code");
        System.out.println(code);
        if(EmailCode.equals(code)){
            user=(User)session.get("user");
            System.out.println(user.getUserAccount());
            if(ud.registerUser(user)>0){
                session.put("succcessRegister","成功注册，进入个人信息网站");
                return SUCCESS;
            }
            session.put("EmailCheckError","注册失败");
            return INPUT;
        }
        session.put("EmailCheckError","验证码错误");
        return INPUT;
    }
}
