package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.BorrowHistoryItem;
import com.sharebookssystem.model.PersonalBook;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 借阅图书
 * 2018/6/24
 */


public class OperatorBorrowBookAction extends ActionSupport {
    private int borrowCode;
    private BookManagementServiceImpl service;
    private List<BorrowHistoryItem> borrowHistoryItemList = new ArrayList<>();
    private List<PersonalBook> personalBookList = new ArrayList<>();
    private String bookStatus; //书本状态
    private int numberOfTimes; //借阅次数
    private Date borrowDate; //借出日期
    private Date shouldReturnDate; //应归还日期
    private String borrowStatus;  //借阅状态
    private int personalBookId;

    public OperatorBorrowBookAction(){

    }

    public int getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(int borrowCode) {
        this.borrowCode = borrowCode;
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

    public int getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(int numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getPersonalBookId() {
        return personalBookId;
    }

    public void setPersonalBookId(int personalBookId) {
        this.personalBookId = personalBookId;
    }

    public Date getShouldReturnDate() {
        return shouldReturnDate;
    }

    public void setShouldReturnDate(Date shouldReturnDate) {
        this.shouldReturnDate = shouldReturnDate;
    }

    public String getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(String borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public String operatorBorrowBook() throws Exception{
        Map m = ActionContext.getContext().getSession();
        borrowHistoryItemList = service.queryBorrowHistoryItemByBorrowCode(borrowCode);
        if(borrowHistoryItemList==null || borrowHistoryItemList.size()==0){
            m.put("operatorBorrowBookError","借阅码不存在,请确认后再重新输入");
            return INPUT;
        }else if(borrowHistoryItemList.get(0).getBorrowStatus().trim().equals("请求借阅")){
            //通过personalBookId查找PersonalBookList
            personalBookId = borrowHistoryItemList.get(0).getPersonalBook().getPersonalBookId();
            personalBookList = service.queryPersonalBookByPersonalBookId(personalBookId);
            if(personalBookList == null || personalBookList.size()==0){
                m.put("operatorBorrowBookError","借阅失败,借阅码无效");
                return INPUT;
            }else{
                if(personalBookList.get(0).getBookStatus().trim().equals("在库")){
                    bookStatus = "借出";
                    numberOfTimes = personalBookList.get(0).getNumberOfTimes()+1;  //借出次数
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                    String nowDate = df.format(new Date());
                    borrowDate = df.parse(nowDate); //借出日期
                    Calendar rightNow = Calendar.getInstance();
                    rightNow.setTime(borrowDate);
                    rightNow.add(Calendar.DAY_OF_YEAR,14); //日期加14天
                    shouldReturnDate=rightNow.getTime();
                    borrowStatus = "未还";
                    personalBookList.get(0).setBookStatus(bookStatus);
                    personalBookList.get(0).setNumberOfTimes(numberOfTimes);
                    borrowHistoryItemList.get(0).setBorrowDate(borrowDate);
                    borrowHistoryItemList.get(0).setShouldReturnDate(shouldReturnDate);
                    borrowHistoryItemList.get(0).setBorrowStatus(borrowStatus);
                    if(service.updatePersonalBookAndBorrowHistoryItem(borrowHistoryItemList.get(0),personalBookList.get(0))){
                        return SUCCESS;
                    }else{
                        m.put("operatorBorrowBookError","借阅失败");
                        return INPUT;
                    }
                }else{
                    m.put("operatorBorrowBookError","借阅失败,借阅码无效");
                    return INPUT;
                }
            }

        }else{
            m.put("operatorBorrowBookError","借阅失败,借阅码已失效");
            return INPUT;
        }
    }

    public void validateOperatorBorrowBook(){
        Map m = ActionContext.getContext().getSession();
        if(borrowCode<1){
            m.put("operatorBorrowBookError","借阅码不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }
    }


}
