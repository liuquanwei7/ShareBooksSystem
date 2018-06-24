package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 删除管理员信息
 * 2018/6/23
 */


public class DeleteManagerInfoAction extends ActionSupport {
    private Manager manager;
    private int managerId;
    private BookManagementServiceImpl service;
    private List<Manager> managerList = new ArrayList<>();

    public DeleteManagerInfoAction(){

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

    public String deleteManagerInfo(){
        managerList = service.queryMangerInfoById(managerId);
        Map m = ActionContext.getContext().getSession();
        m.put("managerDeleteManagerInfoItem",managerList);
        return "confirm";
    }

    public String confirmDeleteManagerInfo(){
        Map m = ActionContext.getContext().getSession();
        managerList = service.queryMangerInfoById(managerId);
        if(managerList==null || managerList.size()==0){
            m.put("managerDeleteManagerInfoError","删除失败，没有查询到该条数据");
            return INPUT;
        }else{
            manager = managerList.get(0);
            if(service.deleteManagerIno(managerId)){
                return SUCCESS;
            }else{
                m.put("managerDeleteManagerInfoError","删除失败");
                return INPUT;
            }
        }
    }
}
