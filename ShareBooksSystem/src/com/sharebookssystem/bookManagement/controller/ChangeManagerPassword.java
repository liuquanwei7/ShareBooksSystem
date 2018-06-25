package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 修改管理员密码
 * 2018/6/23
 */


public class ChangeManagerPassword extends ActionSupport {
    private Manager manager;
    private BookManagementServiceImpl service;
    private List<Manager> list = new ArrayList();
    private String oldManagerPassword;
    private String newManagerPassword;
    private String newManagerPasswordCon;

    public ChangeManagerPassword(){

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

    public String getOldManagerPassword() {
        return oldManagerPassword;
    }

    public void setOldManagerPassword(String oldManagerPassword) {
        this.oldManagerPassword = oldManagerPassword;
    }

    public String getNewManagerPassword() {
        return newManagerPassword;
    }

    public void setNewManagerPassword(String newManagerPassword) {
        this.newManagerPassword = newManagerPassword;
    }

    public String getNewManagerPasswordCon() {
        return newManagerPasswordCon;
    }

    public void setNewManagerPasswordCon(String newManagerPasswordCon) {
        this.newManagerPasswordCon = newManagerPasswordCon;
    }

    public String changeManagerPassword(){
        Map m = ActionContext.getContext().getSession();
        int managerLoginId = Integer.parseInt(m.get("managerLoginId").toString());
        list = service.queryMangerInfoById(managerLoginId);
        manager = list.get(0);
        manager.setManagerPassword(newManagerPassword);

        if(service.updateManagerPassword(manager)){
            return SUCCESS;
        }else {
            m.put("managerChangePasswordError","修改失败");
            return INPUT;
        }

    }

    public void validateChangeManagerPassword(){
        Map s = ActionContext.getContext().getSession();
        if(oldManagerPassword.trim().equals("")){
            s.put("managerChangeOldPasswordError","原密码不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }else if(newManagerPassword.trim().equals("")){
            s.put("managerChangeNewPasswordError","新密码不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }else if(newManagerPassword.trim().length()<6||newManagerPassword.trim().length()>20){
            s.put("managerChangeNewPasswordError","密码长度位6-12位");
            this.addFieldError("managerError","addErrorMessage");
        } else if(newManagerPasswordCon.trim().equals("")){
            s.put("managerChangeNewPasswordConError","确认密码不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }else if(!newManagerPasswordCon.trim().equals(newManagerPassword.trim())){
            s.put("managerChangeNewPasswordConError","输入两次密码不相同");
            this.addFieldError("managerError","addErrorMessage");
        }else if(!oldManagerPassword.trim().equals(s.get("managerLoginPassword").toString().trim())){
            s.put("managerChangeOldPasswordError","原密码不正确");
            this.addFieldError("managerError","addErrorMessage");
        }
    }
}
