package com.sharebookssystem.pan.action;

import com.sharebookssystem.pan.myinterface.BorrowsDataService;
import com.sharebookssystem.pan.myinterface.PageFormat;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;


@Controller("userBooks_DPageAction")
@Scope("prototype")
public class UserBooks_DPageAction implements PageFormat {
    private int which;
    @Resource(name = "userBooks_DService")
    private BorrowsDataService borrowsDataService;

    public String execute(){
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
