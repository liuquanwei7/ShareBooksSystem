package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Manager;

import java.util.Map;

/**
 * 管理员注册
 * 2018/6/21
 */


public class ManagerRegisterAction extends ActionSupport {
    private Manager manager;
    private String managerPasswordCon;
    private BookManagementServiceImpl service;

    public ManagerRegisterAction(){

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

    public String getManagerPasswordCon() {
        return managerPasswordCon;
    }

    public void setManagerPasswordCon(String managerPasswordCon) {
        this.managerPasswordCon = managerPasswordCon;
    }

    public String managerRegister(){
        Map s = ActionContext.getContext().getSession();
        if(service.isSameAccount(manager.getManagerAccount())){
            if(service.registerManager(manager)){
                return SUCCESS;
            }else {
                s.put("managerRegisterAccountError", "注册失败！");
                return INPUT;
            }
        }else{
            s.put("managerRegisterAccountError", "注册失败！邮箱账号已存在");
            return INPUT;
        }

    }

    public void validateManagerRegister(){
        Map s = ActionContext.getContext().getSession();
        if(manager.getManagerAccount().trim().equals("")) {
            s.put("managerRegisterAccountError", "邮箱账号不能为空");
            this.addFieldError("managerError", "addErrorMessage");
        }else if(manager.getManagerPassword().trim().equals("")){
            s.put("managerRegisterPasswordError", "密码不能为空");
            this.addFieldError("managerError", "addErrorMessage");
        }else if(manager.getManagerPassword().trim().length()<6||manager.getManagerPassword().trim().length()>12){
            s.put("managerRegisterPasswordError", "密码长度为6-12位");
            this.addFieldError("managerError", "addErrorMessage");
        }
        else if(managerPasswordCon.trim().equals("")){
            s.put("managerRegisterPasswordConError", "确认密码不能为空");
            this.addFieldError("managerError", "addErrorMessage");
        }else if(!manager.getManagerPassword().trim().equals(managerPasswordCon.trim())){
            s.put("managerRegisterPasswordConError", "确认密码和密码不相同");
            this.addFieldError("managerError", "addErrorMessage");
        }else if(manager.getManagerName().trim().equals("")){
            s.put("managerRegisterNameError", "姓名不能为空");
            this.addFieldError("managerError", "addErrorMessage");
        }
        else if(manager.getManagerName().trim().length()>10){
            s.put("managerRegisterNameError", "姓名长度不能大于10个字符串");
            this.addFieldError("managerError", "addErrorMessage");
        }else if(manager.getManagerAge()==0){
            s.put("managerRegisterAgeError", "年龄不能空");
            this.addFieldError("managerError", "addErrorMessage");
        } else if(manager.getManagerAge()>0) {
            if (manager.getManagerAge() < 10 || manager.getManagerAge() > 120) {
                s.put("managerRegisterAgeError", "年龄不能小于10或大于120岁");
                this.addFieldError("managerError", "addErrorMessage");
            }
        }
    }
}
