package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * 退出登陆
 * 2018/6/23
 */


public class ManagerExitLogin extends ActionSupport {

    public ManagerExitLogin(){

    }

    @Override
    public String execute(){
        Map s = ActionContext.getContext().getSession();
        s.put("managerLoginAccount","");
        s.put("managerLoginId","");
        s.put("managerLoginPassword","");
        s.put("managerLoginName","");
        return SUCCESS;
    }

}
