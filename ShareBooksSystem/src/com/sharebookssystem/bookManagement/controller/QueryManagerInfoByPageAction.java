package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Manager;

import java.util.List;
import java.util.Map;

/**
 * 分页查询管理员信息
 * 2018/6/22
 */


public class QueryManagerInfoByPageAction extends ActionSupport {
    private List<Manager> managers;
    private BookManagementServiceImpl service;
    private int pageNo=1; //计数器,从第1页开始显示
    private int currentPage; //当前页
    private int totalPage; //总页数

    public QueryManagerInfoByPageAction(){

    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
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

    public String queryManagerInfoByPage(){
        Map m = ActionContext.getContext().getSession();
        List list = (List)m.get("managerInfoTempList");
        managers = service.queryManager(list,pageNo);
        if(managers==null){
            return INPUT;
        }else{
            currentPage = (Integer)m.get("managerInfoCurrentPage");
            totalPage=(Integer)m.get("managerInfoTotalPage");
            //提示
            if(pageNo>currentPage){
                m.put("managerInfoPageError","已经是最后一页了！");
            }else if(pageNo<currentPage){
                m.put("managerInfoPageError","已经是第一页了！");
            }else{

            }
            m.put("managerInfo",managers);
            m.put("managerInfoShow","1");   //显示判断
            return SUCCESS;
        }
    }
}
