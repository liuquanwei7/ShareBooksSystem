package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Book;

import java.util.Map;

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
        Map m = ActionContext.getContext().getSession();
        book.setBookPicture(m.get("managerBooksPicture").toString());
        if(service.updateBook(book)){
            return SUCCESS;
        }else{

            m.put("managerUpdateBookError","更新图书失败,请确认好信息后再更新");
            return INPUT;
        }
    }


    public void validateUpdateBook(){
        Map s = ActionContext.getContext().getSession();
        if(book.getBookName().trim().equals("")){
            s.put("managerUpdateBookNameError","书名不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }else if(book.getBookName().trim().length()>50){
            s.put("managerUpdateBookNameError","书名长度不能超过50个字符");
            this.addFieldError("managerError","addErrorMessage");
        }else if(book.getBookAuthor().trim().equals("")){
            s.put("managerUpdateBookAuthorError","作者不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }else if(book.getBookAuthor().trim().length()>50){
            s.put("managerUpdateBookAuthorError","作者长度不能超过50个字符");
            this.addFieldError("managerError","addErrorMessage");
        }else if(book.getBookPublish().trim().equals("")){
            s.put("managerUpdateBookPublishError","出版社不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }else if(book.getBookPublish().trim().length()>30){
            s.put("managerUpdateBookPublishError","出版社长度不能超过30个字符");
            this.addFieldError("managerError","addErrorMessage");
        }else if(book.getBookPrice()<=0){
            s.put("managerUpdateBookPriceError","价格不能小于0元");
            this.addFieldError("managerError","addErrorMessage");
        }


    }
}
