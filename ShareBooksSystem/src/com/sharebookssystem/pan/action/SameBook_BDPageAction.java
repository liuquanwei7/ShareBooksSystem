package com.sharebookssystem.pan.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.User;
import com.sharebookssystem.pan.myinterface.BorrowsDataService;
import com.sharebookssystem.pan.myinterface.PageFormat;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Controller("sameBook_BDPageAction")
@Scope("prototype")
public class SameBook_BDPageAction implements PageFormat {
    private int which;
    Map session;
    @Resource(name = "sameB_B_DService")
    private BorrowsDataService borrowsDataService;

    public String execute(){
        session = ActionContext.getContext().getSession();
        List list = (List)session.get("topFtBData");

        List line = (List)list.get(which);
        int bookId = (int)line.get(1);

        session.put("sameBook_BBId", bookId);

        return "success";
    }


    @Override
    public String firstPage() {
        //初始化当前页所需要的一些判断依据，取出用来执行查询的user
        session = ActionContext.getContext().getSession();
        int bookId = (int)session.get("sameBook_BBId");
        session.put("sameBook_BPage", 0);
        session.put("sameBook_BFirstPage", true);

        Book book = new Book();
        book.setBookId(bookId);

        //获取经过处理的查询结果
        List list = borrowsDataService.service(book, 0);

        if (list == null){
            session.put("sameBook_BData", null);
            return "success";
        }

        if (list.size() < 10){
            session.put("sameBook_BLastPage", true);
        }
        else session.put("sameBook_BLastPage", false);
        session.put("sameBook_BData", list);

        return "success";

    }

    @Override
    public String nextPage() {
        session = ActionContext.getContext().getSession();
        int bookId = (int)session.get("sameBook_BBId");
        int page = (int)session.get("sameBook_BPage");
        page++;
        session.put("sameBook_BPage", page);
        session.put("sameBook_BFirstPage", false);

        Book book = new Book();
        book.setBookId(bookId);

        List list = borrowsDataService.service(book, page);

        if (list == null){
            session.put("sameBook_BData", null);
            session.put("sameBook_BLastPage", true);
            return "success";
        }else session.put("sameBook_BData", list);

        if (list.size() < 10) session.put("sameBook_BLastPage", true);

        return "success";
    }

    @Override
    public String formPage() {
        session = ActionContext.getContext().getSession();
        int bookId = (int)session.get("sameBook_BBId");
        int page = (int)session.get("sameBook_BPage");
        page--;
        session.put("sameBook_BPage", page);
        session.put("sameBook_BFirstPage", false);

        Book book = new Book();
        book.setBookId(bookId);

        List list = borrowsDataService.service(book, page);
        session.put("sameBook_BData", list);


        if (page == 0) session.put("sameBook_BFirstPage", true);

        return "success";
    }

    @Override
    public String nowPage() {
        return null;
    }

    public SameBook_BDPageAction() {
    }

    public int getWhich() {
        return which;
    }

    public void setWhich(int which) {
        this.which = which;
    }

    public BorrowsDataService getBorrowsDataService() {
        return borrowsDataService;
    }

    public void setBorrowsDataService(BorrowsDataService borrowsDataService) {
        this.borrowsDataService = borrowsDataService;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }
}
