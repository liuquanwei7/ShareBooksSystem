package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.BorrowHistoryItem;

/**
 * 确认A已借出
 * 2018/6/10
 */


public class ConfirmFromAAction extends ActionSupport {
    private BorrowHistoryItem borrowHistoryItem;
    private BookManagementServiceImpl service;

    public ConfirmFromAAction(){

    }

    public BorrowHistoryItem getBorrowHistoryItem() {
        return borrowHistoryItem;
    }

    public void setBorrowHistoryItem(BorrowHistoryItem borrowHistoryItem) {
        this.borrowHistoryItem = borrowHistoryItem;
    }

    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
    }

    public String comfirmFromA(){
        if(service.updateBook(borrowHistoryItem)){
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}
