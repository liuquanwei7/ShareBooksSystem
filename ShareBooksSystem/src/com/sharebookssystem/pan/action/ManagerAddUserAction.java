package com.sharebookssystem.pan.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.model.User;
import com.sharebookssystem.pan.myinterface.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller("managerAddUserAction")
@Scope("prototype")
public class ManagerAddUserAction extends ActionSupport {
    private String userName;
    private String userAccount;
    private String userPassword;
    private String s_Password;
    private String userIdentity;
    private String userGender;
    private int userAge;
    private int userPermission;
    private String userEmail;
    @Resource(name = "managerAddUserService")
    private UserService userService;

    @Override
    public String execute(){
        User user = new User();
        user.setUserName(userName);
        user.setUserAccount(userAccount);
        user.setUserPassword(userPassword);
        user.setUserIdentity(userIdentity);
        user.setUserGender(userGender);
        user.setUserAge(userAge);
        user.setUserPermission(userPermission);
        user.setUserEmail(userEmail);

        if (userService.service(user)){
            Map session = ActionContext.getContext().getSession();
            if ((boolean)session.get("userFirstPage")) {
                List list = (List) session.get("queryUsers");
                list.add(0, user);
            }
            return SUCCESS;
        }else {
            addFieldError("managerAddUserFailError", "新增用户失败");
            return INPUT;
        }
    }

    @Override
    public void validate() {
        if (userName.equals("") || userName == null){
            addFieldError("managerAddUserFailError", "名字是必填的");
            return;
        }
        if (userAccount.equals("") || userAccount == null){
            addFieldError("managerAddUserFailError", "账号是必填的");
            return;
        }else if (userAccount.length() < 6 || userAccount.length() > 10){
            addFieldError("managerAddUserFailError", "账号的长度必须在6-10之间");
            return;
        }
        if (userPassword.equals("") || userPassword == null){
            addFieldError("managerAddUserFailError", "密码是必填的");
            return;
        }else if (userPassword.length() < 6 || userPassword.length() > 10){
            addFieldError("managerAddUserFailError", "密码的长度必须在6-10之间");
            return;
        }
        if (s_Password.equals("") || s_Password == null){
            addFieldError("managerAddUserFailError", "确认密码是必填的");
            return;
        }
        if (userEmail.equals("") || userEmail == null){
            addFieldError("managerAddUserFailError", "邮件是必填的");
            return;
        }
        if (userIdentity.equals("") || userIdentity == null){
            addFieldError("managerAddUserFailError", "学号是必填的");
            return;
        }
        if (userAge < 10 || userAge > 80){
            addFieldError("managerAddUserFailError", "年龄必须在10-80之间");
            return;
        }
        if (userPermission < 0 || userPermission > 4){
            addFieldError("managerAddUserFailError", "权限必须在0-4之间");
            return;
        }
        if (!userPassword.equals(s_Password)){
            addFieldError("managerAddUserFailError", "密码与确认密码必须一致");
        }
    }

    public ManagerAddUserAction() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(int userPermission) {
        this.userPermission = userPermission;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getS_Password() {
        return s_Password;
    }

    public void setS_Password(String s_Password) {
        this.s_Password = s_Password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
