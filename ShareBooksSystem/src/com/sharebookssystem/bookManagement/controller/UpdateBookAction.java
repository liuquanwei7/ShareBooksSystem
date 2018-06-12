package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Book;

/**
 * 修改图书
 * 2018/6/10
 */


public class UpdateBookAction extends ActionSupport {
    private Book book;
    private BookManagementServiceImpl service;


    public UpdateBookAction(){

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
    }

    public String updateBook(){
        if(service.updateBook(book)){
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}
