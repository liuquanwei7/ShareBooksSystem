package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Book;

/**
 * 管理员添加图书
 * 2018/6/21
 */


public class ManagerAddBookAction extends ActionSupport {
    private Book managerBook;
    private BookManagementServiceImpl service;

    public ManagerAddBookAction(){

    }

    public Book getManagerBook() {
        return managerBook;
    }

    public void setManagerBook(Book managerBook) {
        this.managerBook = managerBook;
    }

    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
    }

    public String managerAddBook(){
        service.addBook(managerBook);
        return SUCCESS;
    }
}
