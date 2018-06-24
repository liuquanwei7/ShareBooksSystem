package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Manager;

import java.util.Map;

/**
 * 修改管理员信息
 * 2018/6/23
 */


public class UpdateManagerInfoAction extends ActionSupport {
    private Manager manager;
    private BookManagementServiceImpl service;

    public UpdateManagerInfoAction(){

    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
    }

    public String updateManagerInfo(){
        Map m = ActionContext.getContext().getSession();
        manager.setManagerPassword(m.get("managerInfoPassword").toString());
        if(service.updateManagerInfo(manager)){
            return SUCCESS;
        }else {
            m.put("managerUpdateManagerError","更新管理员信息失败,请确认好信息后再更新");
            return INPUT;
        }
    }

    public void validateUpdateManagerInfo(){
        Map s = ActionContext.getContext().getSession();
        if(manager.getManagerAccount().trim().equals("")){
            s.put("managerUpdateManagerAccountError","邮箱账号不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }else if(manager.getManagerName().trim().equals("")){
            s.put("managerUpdateManagerNameError","姓名不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }else if(manager.getManagerName().trim().length()>20){
            s.put("managerUpdateManagerNameError","姓名长度不能超过20");
            this.addFieldError("managerError","addErrorMessage");
        }else if(manager.getManagerAge()<10||manager.getManagerAge()>120){
            s.put("managerUpdateManagerAgeError","年龄不合法");
            this.addFieldError("managerError","addErrorMessage");
        }
    }
}
