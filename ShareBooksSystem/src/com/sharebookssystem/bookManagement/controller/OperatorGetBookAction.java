package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.PersonalBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 收回图书
 * 2018/6/24
 */


public class OperatorGetBookAction extends ActionSupport {
    private String getBookCode;
    private BookManagementServiceImpl service;
    private List<PersonalBook> personalBookList = new ArrayList<>();
    private String bookStatus;

    public OperatorGetBookAction(){

    }

    public String getGetBookCode() {
        return getBookCode;
    }

    public void setGetBookCode(String getBookCode) {
        this.getBookCode = getBookCode;
    }

    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String operatorGetBook(){
        Map m = ActionContext.getContext().getSession();
        personalBookList = service.queryPersonalBookByGetBookCode(getBookCode);
        if(personalBookList == null || personalBookList.size() == 0){
            m.put("operatorGetBookError","索回码不存在,请确认后再重新输入");
            return INPUT;
        }else if(personalBookList.get(0).getBookStatus().trim().equals("请求索回")){
            bookStatus = "不在库";
            personalBookList.get(0).setBookStatus(bookStatus);
            if(service.updatePersonalBook(personalBookList.get(0))){
                return SUCCESS;
            }else{
                m.put("operatorGetBookError","索回失败");
                return INPUT;
            }
        }else{
            m.put("operatorGetBookError","索回码已失效");
            return INPUT;
        }
    }

    public void validateOperatorGetBook(){
        Map m = ActionContext.getContext().getSession();
        if(getBookCode.trim().equals("")){
            m.put("operatorGetBookError","索回码不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }
    }
}
