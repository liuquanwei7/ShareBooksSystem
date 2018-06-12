package com.sharebookssystem.pan.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.model.User;
import com.sharebookssystem.pan.myinterface.PageFormat;
import com.sharebookssystem.pan.myinterface.UserService;
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

    //定义将要用来查询的user对象
    public String execute(){
        session = ActionContext.getContext().getSession();

        User queryUser = new User();
        //初始化用来传递参数的查询user对象，设为空，方便后续判断
        queryUser.setUserName(null);
        queryUser.setUserIdentity(null);
        queryUser.setUserPermission(-1);

        //若是没进行过查询，即第一次进入页面，需要展示初始信息
        if (session.get("queryUser") == null){
            session.put("queryUser", queryUser);
            return "success";
        }

        //判断提交上来的数据是否有值
        if (userName != null && !userName.equals("")) queryUser.setUserName(userName);
        if (userIdentity != null && !userIdentity.equals("")) queryUser.setUserName(userIdentity);
        if (userPermission != -1) queryUser.setUserPermission(userPermission);
        session.put("queryUser", queryUser);

        return "success";
    }

    @Override
    //显示符合条件的用户的首页
    public String firstPage() {
        session = ActionContext.getContext().getSession();
        User queryUser = (User)session.get("queryUser");

        //初始化session上有关userPage的存取的值
        session.put("userPage", 0);
        session.put("userFirstPage", true);

        //取出所查询到的user列表,判断是否查询到
        List<User> resultUsers = userService.service(queryUser, 0);
        if (resultUsers == null) {
            session.put("queryUsers", null);
            return "success";
        } else session.put("queryUsers", resultUsers);

        //判断是否最后一页
        if (resultUsers.size() < 10) session.put("userLastPage", true);
        else session.put("userLastPage", false);

        return "success";
    }

    @Override
    //读取下一页的用户
    public String nextPage() {
        session = ActionContext.getContext().getSession();
        int page = (int)session.get("userPage");
        page++;
        session.put("userPage", page);
        session.put("userFirstPage", false);
        User queryUser = (User) session.get("queryUser");

        List<User> resultUsers = userService.service(queryUser, page);
        if (resultUsers == null) {
            session.put("queryUsers", null);
            session.put("userLastPage", true);
            return "success";
        }else session.put("queryUsers", resultUsers);

        if (resultUsers.size() < 10) session.put("userLastPage", true);

        return "success";
    }

    @Override
    //读取上一页的用户
    public String formPage() {
        //从session取出需要的变量的值,并把需要的变化放进去
        session = ActionContext.getContext().getSession();
        int page = (int)session.get("userPage");
        page--;
        session.put("userPage", page);
        session.put("userLastPage", false);
        User queryUser = (User) session.get("queryUser");

        //根据session取出的user进行查询
        List<User> resultUsers = userService.service(queryUser, page);
        session.put("queryUsers", resultUsers);

        //判断是否到了首页
        if (page == 0) session.put("userFirstPage", true);

        return "success";
    }

    @Override
    public String nowPage() {
//        session = ActionContext.getContext().getSession();
//        if (session.get("queryUser") == null) return "noResult";
//
//        int page = (int)session.get("userPage");
//        User queryUser = (User) session.get("queryUser");
//
//        System.out.println(userService == null);
//
//        System.out.println("111");
//        //根据session取出的user进行查询
//        List<User> resultUsers = userService.service(queryUser, page);
//        System.out.println("222");
//        session.put("queryUsers", resultUsers);
//        System.out.println("333");

        return "success";
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
