package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Book;

/**
 * 删除图书
 * 2018/6/10
 */


public class DeleteBook extends ActionSupport {
    private Book book;
    private BookManagementServiceImpl service;

    public DeleteBook(){

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

    public String deleteBook(){
        if(service.deleteBook(book,book.getBookId())){
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}
