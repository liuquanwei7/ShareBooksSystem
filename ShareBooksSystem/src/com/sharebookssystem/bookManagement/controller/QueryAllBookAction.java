package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 查询所有图书信息
 * 2018/6/22
 */


public class QueryAllBookAction extends ActionSupport {
    private BookManagementServiceImpl service;
    private List<Book> books = new ArrayList<>();
    private int pageNo=1;
    private int CurrentPage;

    public QueryAllBookAction(){

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
        return CurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        CurrentPage = currentPage;
    }

    public String queryAllBook(){
        Map m = ActionContext.getContext().getSession();
        m.put("managerBooks","");
        List list = new ArrayList();
        list.add("all");
        m.put("managerBookTempList",list);  //分页查询
        books = service.queryBook(list,pageNo);
        if(books==null||books.size()==0){
            m.put("managerQueryNullError","抱歉,没有查到相关的图书,请输入正确的图书信息");
            return INPUT;
        }else{
            CurrentPage = 1;
            m.put("managerBooks",books);     //jsp页面迭代显示
            m.put("managerBookShow","1");   //显示判断
            return SUCCESS;
        }
    }
}
