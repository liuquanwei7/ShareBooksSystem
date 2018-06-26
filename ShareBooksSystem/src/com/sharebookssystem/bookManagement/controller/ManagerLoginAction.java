package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.dao.hibernate.BookManagementDaoImpl;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Manager;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 管理员登陆
 * 2018/6/5
 */

public class ManagerLoginAction extends ActionSupport {
    private Manager manager;
    private List<Manager> managers = new ArrayList<>();
    private BookManagementServiceImpl service;
    private List list = new ArrayList();

    public ManagerLoginAction(){

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

    public String login(){
        Map s = ActionContext.getContext().getSession();
        //验证登陆
        if(service.isExistManager(manager.getManagerAccount(),manager.getManagerPassword(),manager.getManagerPermission())){
           list.add("managerAccount");
           list.add(manager.getManagerAccount());
            managers = service.queryManager(list,1);
            s.put("managerAccount",manager.getManagerAccount());
            s.put("managerLoginAccount",managers.get(0).getManagerAccount());
            s.put("managerLoginId",managers.get(0).getManagerId());
            s.put("managerLoginPassword",managers.get(0).getManagerPassword());
            s.put("managerLoginName",managers.get(0).getManagerName());
            //跳转到管理员页面
            if(manager.getManagerPermission()==0){
                return "manager";
            }else if(manager.getManagerPermission()==1){
                return "operator"; //跳转到操作员页面
            }else if(manager.getManagerPermission()==2){
                return "admin";
            }else{
                return INPUT;
            }
        }else{
            if(s.get("managerLoginAccountError")==null &&s.get("managerLoginPasswordError")==null){
                s.put("managerLoginNoAccountError","账户不存在或密码有误！");
            }
            return INPUT;
        }

    }


    public void validateLogin(){
        Map s = ActionContext.getContext().getSession();
        if(manager.getManagerAccount().trim().equals("")){
            s.put("managerLoginAccountError","邮箱账户不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }else{
            if(manager.getManagerPassword().trim().equals("")){
                s.put("managerLoginPasswordError","密码不能为空");
                this.addFieldError("managerError","addErrorMessage");
            }
        }


    }

}
