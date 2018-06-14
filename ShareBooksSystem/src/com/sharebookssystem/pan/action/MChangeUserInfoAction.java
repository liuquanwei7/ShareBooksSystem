package com.sharebookssystem.pan.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.model.User;
import com.sharebookssystem.pan.myinterface.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

@Controller("managerChangeUserInfoAction")
@Scope("prototype")
public class MChangeUserInfoAction extends ActionSupport {
    private String userName;
    private String userAccount;
    private String userPassword;
    private String userIdentity;
    private String userGender;
    private int userAge;
    private int userPermission;
    private Map session;
    @Resource(name = "mChangeUserInfoService")
    private UserService userService;

    @Override
    public String execute(){
        session = ActionContext.getContext().getSession();

        User user = (User)session.get("managerChooseUser");
        user.setUserName(userName);
        user.setUserAccount(userAccount);
        user.setUserPassword(userPassword);
        user.setUserIdentity(userIdentity);
        user.setUserGender(userGender);
        user.setUserAge(userAge);
        user.setUserPermission(userPermission);

        if (userService.service(user)){
            return SUCCESS;
        }else {
            addFieldError("managerChangeUserFailError", "更新用户失败");
            return INPUT;
        }
    }

    @Override
    public void validate() {
        if (userName.equals("") || userName == null){
            addFieldError("managerChangeUserFailError", "名字是必填的");
            return;
        }
        if (userAccount.equals("") || userAccount == null){
            addFieldError("managerChangeUserFailError", "账号是必填的");
            return;
        }else if (userAccount.length() < 6 || userAccount.length() > 10){
            addFieldError("managerChangeUserFailError", "账号的长度必须在6-10之间");
            return;
        }
        if (userPassword.equals("") || userPassword == null){
            addFieldError("managerChangeUserFailError", "密码是必填的");
            return;
        }else if (userPassword.length() < 6 || userPassword.length() > 10){
            addFieldError("managerChangeUserFailError", "密码的长度必须在6-10之间");
            return;
        }
        if (userIdentity.equals("") || userIdentity == null){
            addFieldError("managerChangeUserFailError", "学号是必填的");
            return;
        }
        if (userAge < 10 || userAge > 80){
            addFieldError("managerChangeUserFailError", "年龄必须在10-80之间");
            return;
        }
        if (userPermission < 0 || userPermission > 4){
            addFieldError("managerChangeUserFailError", "权限必须在0-4之间");
            return;
        }
    }

    public MChangeUserInfoAction() {
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
}
