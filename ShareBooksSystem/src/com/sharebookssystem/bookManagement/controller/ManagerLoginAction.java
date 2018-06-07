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
import java.util.Map;

/**
 * 管理员登陆
 * 2018/6/5
 */
@Namespace("/bookManagement")
@ParentPackage("convention-default")
@Action(value = "managerLoginAction",
        results = { @Result(name = "success", location = "test.jsp"),
                    @Result(name = "input", location = "test.jsp") })

public class ManagerLoginAction extends ActionSupport {
    private Manager manager;

    @Resource
    private BookManagementServiceImpl service;

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

    public String excute() throws Exception{
        Map s = ActionContext.getContext().getSession();
        //验证登陆
        if(service.isExistManager(manager)){
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}
