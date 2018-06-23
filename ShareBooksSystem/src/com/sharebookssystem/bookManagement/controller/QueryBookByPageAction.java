package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Book;

import java.util.List;
import java.util.Map;

/**
 * 分页查询
 * 2018/6/14
 */


public class QueryBookByPageAction extends ActionSupport {
    private List<Book> books;
    private BookManagementServiceImpl service;
    private int pageNo=1; //计数器,从第1页开始显示
    private int currentPage; //当前页
    private int totalPage; //总页数

    public QueryBookByPageAction(){

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
    }

    public String queryBookByPage(){
        Map m = ActionContext.getContext().getSession();
        List list = (List)m.get("managerBookTempList");
        books = service.queryBook(list,pageNo);
        if(books==null){
            return INPUT;
        }else{
            currentPage = (Integer)m.get("managerCurrentPage");
            totalPage=(Integer)m.get("managerTotalPage");
            //提示
            if(pageNo>currentPage){
                m.put("managerPageError","已经是最后一页了！");
            }else if(pageNo<currentPage){
                m.put("managerPageError","已经是第一页了！");
            }else{

            }
            m.put("managerBooks",books);
            m.put("managerBookShow","1");   //显示判断
            return SUCCESS;
        }

    }


}
