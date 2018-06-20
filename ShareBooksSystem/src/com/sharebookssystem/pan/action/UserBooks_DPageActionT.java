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


@Controller("userBooks_DPageActionT")
@Scope("prototype")
public class UserBooks_DPageActionT implements PageFormat {
    private int which;
    private Map session;
    @Resource(name = "userBooks_DService")
    private BorrowsDataService borrowsDataService;

    public String execute(){
        session = ActionContext.getContext().getSession();
        //从session取出需要进行查询的User
        List getList = (List) session.get("topFtBData");
        List line = (List)getList.get(which);
        int userId = (int)line.get(0);

        session.put("queryBooks_DByUserIdT", userId);

        return "success";
    }

    @Override
    public String firstPage() {
        //初始化当前页所需要的一些判断依据，取出用来执行查询的user
        session = ActionContext.getContext().getSession();
        int userId = (int)session.get("queryBooks_DByUserIdT");
        session.put("userBooks_DPage", 0);
        session.put("userBooks_DFirstPage", true);

        User user = new User();
        user.setUserId(userId);

        //获取经过处理的查询结果
        List list = borrowsDataService.service(user, 0);

        if (list == null){
            session.put("userBooksData", null);
            return "success";
        }

        if (list.size() < 10){
            session.put("userBooks_DLastPage", true);
        }
        else session.put("userBooks_DLastPage", false);
        session.put("userBooksData", list);

        return "success";
    }

    @Override
    public String nextPage() {
        session = ActionContext.getContext().getSession();
        int page = (int)session.get("userBooks_DPage");
        page++;
        session.put("userBooks_DPage", page);
        session.put("userBooks_DFirstPage", false);
        int userId = (int)session.get("queryBooks_DByUserIdT");

        User user = new User();
        user.setUserId(userId);

        List list = borrowsDataService.service(user, page);
        if (list != null) session.put("userBooksData", list);
        else{
            session.put("userBooksData", null);
            session.put("userBooks_DLastPage", true);
            return "success";
        }

        if (list.size() < 10) session.put("userBooks_DLastPage", true);

        return "success";
    }

    @Override
    public String formPage() {
        session = ActionContext.getContext().getSession();
        int page = (int)session.get("userBooks_DPage");
        page--;
        session.put("userBooks_DPage", page);
        session.put("userBooks_DLastPage", false);
        int userId = (int) session.get("queryBooks_DByUserIdT");

        User user = new User();
        user.setUserId(userId);

        //根据session取出的user进行查询
        List list = borrowsDataService.service(user, page);
        session.put("userBooksData", list);


        if (page == 0) session.put("userBooks_DFirstPage", true);

        return "success";
    }

    @Override
    public String nowPage() {
        return null;
    }

    public UserBooks_DPageActionT() {
    }

    public int getWhich() {
        return which;
    }

    public void setWhich(int which) {
        this.which = which;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public BorrowsDataService getBorrowsDataService() {
        return borrowsDataService;
    }

    public void setBorrowsDataService(BorrowsDataService borrowsDataService) {
        this.borrowsDataService = borrowsDataService;
    }
}
