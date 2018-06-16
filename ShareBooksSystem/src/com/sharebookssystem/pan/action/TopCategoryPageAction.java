package com.sharebookssystem.pan.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.pan.myinterface.BorrowsDataService;
import com.sharebookssystem.pan.myinterface.PageFormat;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller("topCategoryPageAction")
@Scope("prototype")
public class TopCategoryPageAction implements PageFormat {
    private Date startTime;
    private Date endTime;
    Map session;
    @Resource(name = "topCategoryPageService")
    private BorrowsDataService borrowsDataService;

    public String execute(){
        session = ActionContext.getContext().getSession();

        if (startTime == null || startTime.equals("")) startTime = null;
        if (endTime == null || endTime.equals("")) endTime = null;

        session.put("topCategoryStartTime", startTime);
        session.put("topCategoryEndTime", endTime);

        return "success";
    }

    @Override
    public String firstPage() {
        session = ActionContext.getContext().getSession();
        session.put("topCategoryPage", 0);
        session.put("topCategoryFirstPage", true);

        startTime = (Date)session.get("topCategoryStartTime");
        endTime = (Date)session.get("topCategoryEndTime");

        List list = borrowsDataService.service(startTime, endTime, 0);

        if (list == null){
            session.put("topCategoryData", null);
            return "success";
        }

        if (list.size() < 10){
            session.put("topCategoryLastPage", true);
        }
        else session.put("topCategoryLastPage", false);
        session.put("topCategoryData", list);

        return "success";
    }

    @Override
    public String nextPage() {
        session = ActionContext.getContext().getSession();
        int page = (int)session.get("topCategoryPage");
        page++;
        session.put("topCategoryPage", page);
        session.put("topCategoryFirstPage", false);

        startTime = (Date)session.get("topCategoryStartTime");
        endTime = (Date)session.get("topCategoryEndTime");

        List list = borrowsDataService.service(startTime, endTime, page);

        //System.out.println(list.size());

        if (list == null){
            session.put("topCategoryData", null);
            session.put("topCategoryLastPage", true);
            return "success";
        }else session.put("topCategoryData", list);

        if (list.size() < 10) session.put("topCategoryLastPage", true);

        return "success";
    }

    @Override
    public String formPage() {
        session = ActionContext.getContext().getSession();
        int page = (int)session.get("topCategoryPage");
        page--;
        session.put("topCategoryPage", page);
        session.put("topCategoryLastPage", false);

        startTime = (Date)session.get("topCategoryStartTime");
        endTime = (Date)session.get("topCategoryEndTime");

        List list = borrowsDataService.service(startTime, endTime, page);
        session.put("topCategoryData", list);


        if (page == 0) session.put("topCategoryFirstPage", true);

        return "success";
    }

    @Override
    public String nowPage() {
        session = ActionContext.getContext().getSession();

        if (session.get("topCategoryPage") == null) return "noInit";

        int page = (int)session.get("topCategoryPage");


        startTime = (Date)session.get("topCategoryStartTime");
        endTime = (Date)session.get("topCategoryEndTime");

        List list = borrowsDataService.service(startTime, endTime, page);
        session.put("topCategoryData", list);

        return "success";
    }

    public TopCategoryPageAction() {
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
