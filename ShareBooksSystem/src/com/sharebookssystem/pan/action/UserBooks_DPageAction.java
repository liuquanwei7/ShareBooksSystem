package com.sharebookssystem.pan.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.model.User;
import com.sharebookssystem.pan.myinterface.BorrowsDataService;
import com.sharebookssystem.pan.myinterface.PageFormat;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Controller("userBooks_DPageAction")
@Scope("prototype")
public class UserBooks_DPageAction implements PageFormat {
    private int which;
    private Map session;
    @Resource(name = "userBooks_DService")
    private BorrowsDataService borrowsDataService;

    public String execute(){
        session = ActionContext.getContext().getSession();
        //从session取出需要进行查询的User
        List<User> getUserList = (List<User>) session.get("queryUsers");
        User user = getUserList.get(which);

        borrowsDataService.service(user);

        return null;
    }

    @Override
    public String firstPage() {
        return null;
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

    public int getWhich() {
        return which;
    }

    public void setWhich(int which) {
        this.which = which;
    }

    public UserBooks_DPageAction() {
    }
}
