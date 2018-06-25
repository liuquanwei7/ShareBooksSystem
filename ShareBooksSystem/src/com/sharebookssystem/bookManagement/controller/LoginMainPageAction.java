package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.BorrowHistoryItem;
import com.sharebookssystem.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 主页显示
 * 2018/6/25
 */


public class LoginMainPageAction extends ActionSupport {
    private BookManagementServiceImpl service;
    private int countOfBooks;
    private int countOfBorrowHistory;
    private int countOfComment;
    private int countOfUser;
    private int countOfManager;

    public LoginMainPageAction(){

    }

    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
    }

    public int getCountOfBooks() {
        return countOfBooks;
    }

    public void setCountOfBooks(int countOfBooks) {
        this.countOfBooks = countOfBooks;
    }

    public int getCountOfBorrowHistory() {
        return countOfBorrowHistory;
    }

    public void setCountOfBorrowHistory(int countOfBorrowHistory) {
        this.countOfBorrowHistory = countOfBorrowHistory;
    }

    public int getCountOfUser() {
        return countOfUser;
    }

    public void setCountOfUser(int countOfUser) {
        this.countOfUser = countOfUser;
    }

    public int getCountOfManager() {
        return countOfManager;
    }

    public void setCountOfManager(int countOfManager) {
        this.countOfManager = countOfManager;
    }

    public String loginMainPage(){
        countOfBooks = service.queryCountOfBook();
        countOfBorrowHistory = service.queryCountOfBorrowHistory();
        countOfUser = service.queryCountOfUser();
        countOfManager = service.queryCountOfManager();
        countOfComment = service.queryCountOfComment();
        Map m = ActionContext.getContext().getSession();
        m.put("managerCountOfBooks",countOfBooks);
        m.put("managerCountOfBorrowHistory",countOfBorrowHistory);
        m.put("managerCountOfUser",countOfUser);
        m.put("managerCountOfManager",countOfManager);
        m.put("managerCountOfComment",countOfComment);
        return SUCCESS;
    }
}
