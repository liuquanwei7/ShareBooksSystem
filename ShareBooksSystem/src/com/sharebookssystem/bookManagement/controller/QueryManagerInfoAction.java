package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 查询管理员信息
 * 2018/6/22
 */


public class QueryManagerInfoAction extends ActionSupport {
    private Manager manager;
    private BookManagementServiceImpl service;
    private int id; //界面显示数据的索引
    private int pageNo=1; //计数器,从第1页开始显示
    private int currentPage; //当前页
    private int totalPage; //总页数
    private List<Manager> managers = new ArrayList<>();

    public QueryManagerInfoAction(){

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String queryManagerInfo(){
        Map m = ActionContext.getContext().getSession();
        m.put("managerInfo","");
        List list = new ArrayList();
        if(manager!=null){
            m.put("managerInfoTemp",manager);
        }else {
            return INPUT;
        }

        if(!manager.getManagerAccount().trim().equals("")){
            list.add("managerAccount");
            list.add(manager.getManagerAccount());
        }else if(manager.getManagerPermission()==0||manager.getManagerPermission()==1){
            list.add("managerPermission");
            list.add(manager.getManagerPermission());
        }else {

        }
        m.put("managerInfoTempList",list);  //分页查询

        if(list.size()>0){
            managers = service.queryManager(list,pageNo);
            if(managers==null){
                m.put("managerInfoError","抱歉,没有查到相关管理员信息,请确认好信息再查询");
                return INPUT;
            }else {
                currentPage=1;
                totalPage=(Integer)m.get("managerInfoTotalPage");
                m.put("managerInfo",managers);
                m.put("managerInfoShow","1");
                return SUCCESS;
            }
        }else {
            m.put("managerInfoError","抱歉,没有查到相关管理员信息,请确认好信息再查询");
            return INPUT;
        }
    }

    public void validateQueryManagerInfo(){
        Map s = ActionContext.getContext().getSession();
        if(manager.getManagerAccount().trim().equals("")&&manager.getManagerPermission()==2){
            s.put("managerInfoError","不能为空，至少填一项！");
            this.addFieldError("managerError","addErrorMessage");
        }else if(manager.getManagerAccount().trim().length()>20){
            s.put("managerInfoError","邮箱账户长度不能大于20");
            this.addFieldError("managerError","addErrorMessage");
        }
    }
}
