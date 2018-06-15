package com.sharebookssystem.pan.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.pan.myinterface.BorrowsDataService;
import com.sharebookssystem.pan.myinterface.PageFormat;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller("sameCategoryDBPage")
@Scope("prototype")
public class SameCategoryBDPage implements PageFormat {
    private int which;
    private Map session;
    @Resource(name = "sameCategoryBDService")
    private BorrowsDataService borrowsDataService;

    public String execute(){
        session = ActionContext.getContext().getSession();
        List list = (List)session.get("topCategoryData");

        List line = (List)list.get(which);
        String category = (String)line.get(0);

        session.put("queryBDByCategory", category);

        return "success";
    }

    @Override
    public String firstPage() {
        session = ActionContext.getContext().getSession();
        String category = (String)session.get("queryBDByCategory");

        session.put("sameCategoryBDPage", 0);
        session.put("sameCategoryBDFirstPage", true);

        List list = borrowsDataService.service(category, 0);

        if (list == null){
            session.put("sameCategoryBData", null);
            return "success";
        }

        if (list.size() < 10){
            session.put("sameCategoryBDLastPage", true);
        }
        else session.put("sameCategoryBDLastPage", false);

        session.put("sameCategoryBData", list);

        return "success";
    }

    @Override
    public String nextPage() {
        session = ActionContext.getContext().getSession();
        String category = (String)session.get("queryBDByCategory");

        int page = (int)session.get("sameCategoryBDPage");
        page++;
        session.put("sameCategoryBDPage", page);
        session.put("sameCategoryBDFirstPage", false);


        List list = borrowsDataService.service(category, page);

        if (list == null){
            session.put("sameCategoryBData", null);
            session.put("sameCategoryBDLastPage", true);
            return "success";
        }else session.put("sameCategoryBData", list);

        if (list.size() < 10) session.put("sameCategoryBDLastPage", true);

        return "success";
    }

    @Override
    public String formPage() {
        session = ActionContext.getContext().getSession();
        String category = (String)session.get("queryBDByCategory");

        int page = (int)session.get("sameCategoryBDPage");
        page--;
        session.put("sameCategoryBDPage", page);
        session.put("sameCategoryBDFirstPage", false);


        List list = borrowsDataService.service(category, page);
        session.put("sameCategoryBData", list);


        if (page == 0) session.put("sameCategoryBDFirstPage", true);

        return "success";
    }

    @Override
    public String nowPage() {
        return null;
    }

    public SameCategoryBDPage() {
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
