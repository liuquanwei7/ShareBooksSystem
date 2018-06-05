package com.sharebookssystem.pan.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.model.User;
import com.sharebookssystem.pan.myinterface.PageFormat;
import com.sharebookssystem.pan.myinterface.UserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller("userPageAction")
@Scope("prototype")
public class UserPageAction implements PageFormat {
    private String userName;
    private String userIdentity;
    private int userPermission;
    @Resource(name = "userPageService")
    private UserService userService;
    private Map session;

    @Override
    public String firstPage() {
        //初始化session上有关userPage的存取的值
        session = ActionContext.getContext().getSession();
        session.put("userPage", 0);
        session.put("userFirstPage", true);
        session.put("userPageMessage", null);

        User queryUser = new User();
        //初始化用来传递参数的查询user对象，设为空，方便后续判断
        queryUser.setUserName(null);
        queryUser.setUserIdentity(null);
        queryUser.setUserPermission(-1);

        //判断提交上来的数据是否有值
        if (userName != null && !userName.equals("")) queryUser.setUserName(userName);
        if (userIdentity != null && !userIdentity.equals("")) queryUser.setUserName(userIdentity);
        if (userPermission != -1) queryUser.setUserPermission(userPermission);

        //取出所查询到的user列表,判断是否查询到
        List<User> resultUsers = userService.service(queryUser, 0);
        if (resultUsers == null) {
            session.put("queryUsers", null);
            session.put("userPageMessage", "所查用户不存在");
            return "success";
        }
        else session.put("queryUsers", resultUsers);

        //判断是否最后一页
        if (resultUsers.size() < 10) session.put("userLastPage", true);
        else session.put("userLastPage", false);

        return "success";
    }

    @Override
    public String nextPage() {
        return null;
    }

    @Override
    public String formPage() {
        return null;
    }

    @Override
    public String nowPage() {
        return null;
    }

    public UserPageAction() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
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
