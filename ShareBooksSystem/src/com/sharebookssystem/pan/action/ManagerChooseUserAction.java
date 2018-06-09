package com.sharebookssystem.pan.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller("managerChooseUserAction")
@Scope("prototype")
public class ManagerChooseUserAction {
    private int which;
    private Map session;

    public String execute(){
        session = ActionContext.getContext().getSession();
        List list = (List)session.get("queryUsers");

        User user = (User)list.get(which);
        session.put("managerChooseUser", user);
        return "success";
    }

    public int getWhich() {
        return which;
    }

    public void setWhich(int which) {
        this.which = which;
    }

    public ManagerChooseUserAction() {
    }
}
