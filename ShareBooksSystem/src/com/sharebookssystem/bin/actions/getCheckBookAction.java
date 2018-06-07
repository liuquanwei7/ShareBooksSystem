package com.sharebookssystem.bin.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class getCheckBookAction extends ActionSupport {
    String check_data;
    public getCheckBookAction(){

    }

    public String getCheck_data() {
        return check_data;
    }

    public void setCheck_data(String check_data) {
        this.check_data = check_data;
    }

    public String execute(){
        if(check_data!=null){
            Map map=ActionContext.getContext().getSession();
            map.put("check_data",check_data);
            return SUCCESS;
        }else {
            return INPUT;
        }
    }
}
