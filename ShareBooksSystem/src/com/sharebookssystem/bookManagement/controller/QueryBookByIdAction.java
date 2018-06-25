package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 通过id查询图书
 * 2018/6/18
 */


public class QueryBookByIdAction extends ActionSupport {
    private List<Book> temp = new ArrayList<>();
    private Book managerBooks;
    private int bookId;
    private BookManagementServiceImpl service;

    public QueryBookByIdAction(){

    }

    public Book getManagerBooks() {
        return managerBooks;
    }

    public void setManagerBooks(Book managerBooks) {
        this.managerBooks = managerBooks;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
    }

    public String queryBookById(){
        temp=service.queryBookById(bookId);
        managerBooks = temp.get(0);
        Map m = ActionContext.getContext().getSession();
        m.put("managerBooksPicture",managerBooks.getBookPicture());
        m.put("managerBooks",managerBooks); //修改图书页面显示
        if(managerBooks!=null){
            return SUCCESS;
        }else {
            return INPUT;
        }

    }
}
