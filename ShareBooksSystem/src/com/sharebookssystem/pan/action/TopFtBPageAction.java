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

@Controller("topFtBPageAction")
@Scope("prototype")
public class TopFtBPageAction implements PageFormat {
    private Date startTime;
    private Date endTime;
    private Map session;
    @Resource(name = "topFtBPageService")
    private BorrowsDataService borrowsDataService;

    public String execute(){
        session = ActionContext.getContext().getSession();

        if (startTime == null || startTime.equals("")) startTime = null;
        if (endTime == null || endTime.equals("")) endTime = null;

        session.put("topFtBStartTime", startTime);
        session.put("topFtBEndTime", endTime);

        return "success";
    }

    @Override
    public String firstPage() {
        session = ActionContext.getContext().getSession();
        session.put("topFtBPage", 0);
        session.put("topFtBFirstPage", true);

        startTime = (Date)session.get("topFtBStartTime");
        endTime = (Date)session.get("topFtBEndTime");

        List list = borrowsDataService.service(startTime, endTime, 0);

        if (list == null){
            session.put("topFtBData", null);
            return "success";
        }

        if (list.size() < 10){
            session.put("topFtBLastPage", true);
        }
        else session.put("topFtBLastPage", false);
        session.put("topFtBData", list);

        return "success";
    }

    @Override
    public String nextPage() {
        session = ActionContext.getContext().getSession();
        int page = (int)session.get("topFtBPage");
        page++;
        session.put("topFtBPage", page);
        session.put("topFtBFirstPage", false);

        startTime = (Date)session.get("topFtBStartTime");
        endTime = (Date)session.get("topFtBEndTime");

        List list = borrowsDataService.service(startTime, endTime, page);

        if (list == null){
            session.put("topFtBData", null);
            session.put("topFtBLastPage", true);
            return "success";
        }else session.put("topFtBData", list);

        if (list.size() < 10) session.put("topFtBLastPage", true);

        return "success";
    }

    @Override
    public String formPage() {
        session = ActionContext.getContext().getSession();
        int page = (int)session.get("topFtBPage");
        page--;
        session.put("topFtBPage", page);
        session.put("topFtBLastPage", false);

        startTime = (Date)session.get("topFtBStartTime");
        endTime = (Date)session.get("topFtBEndTime");

        List list = borrowsDataService.service(startTime, endTime, page);
        session.put("topFtBData", list);


        if (page == 0) session.put("topFtBFirstPage", true);

        return "success";
    }

    @Override
    public String nowPage() {
        session = ActionContext.getContext().getSession();

        if (session.get("topFtBPage") == null) return "noInit";

        int page = (int)session.get("topFtBPage");


        startTime = (Date)session.get("topFtBStartTime");
        endTime = (Date)session.get("topFtBEndTime");

        List list = borrowsDataService.service(startTime, endTime, page);
        session.put("topFtBData", list);

        return "success";
    }

    public TopFtBPageAction() {
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

    public BorrowsDataService getBorrowsDataService() {
        return borrowsDataService;
    }

    public void setBorrowsDataService(BorrowsDataService borrowsDataService) {
        this.borrowsDataService = borrowsDataService;
    }
}
