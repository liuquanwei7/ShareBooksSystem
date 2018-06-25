package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 修改管理员信息
 * 2018/6/23
 */


public class QueryManagerInfoByIdAction extends ActionSupport {
    private Manager manager;
    private int managerId;
    private List<Manager> list = new ArrayList();
    private BookManagementServiceImpl service;

    public QueryManagerInfoByIdAction(){

    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
    }

    public String queryManagerInfoById(){
        list = service.queryMangerInfoById(managerId);
        manager = list.get(0);
        Map m = ActionContext.getContext().getSession();
        m.put("managerInfo",manager); //修改管理员信息页面显示
        m.put("managerInfoPassword",manager.getManagerPassword());
        if(manager!=null){
            return SUCCESS;
        }else {
            return INPUT;
        }
    }
}
