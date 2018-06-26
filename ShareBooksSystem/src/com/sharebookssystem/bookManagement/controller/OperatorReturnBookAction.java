package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.bookUi.utils.MailUitls;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.BorrowHistoryItem;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 归还图书
 * 2018/6/24
 */


public class OperatorReturnBookAction extends ActionSupport {
    private String returnCode;
    private BookManagementServiceImpl service;
    private List<BorrowHistoryItem> borrowHistoryItemList = new ArrayList<>();
    private List<PersonalBook> personalBookList = new ArrayList<>();
    private int personalBookId;
    private String bookStatus;
    private Date actualReturnDate;  //实际归还日期
    private String borrowStatus;    //借阅状态
    private int userId ;
    private List<User> userList;
    private String getBookMessage;
    private int bookId;
    private List<Book> bookList = new ArrayList<>();

    public OperatorReturnBookAction(){

    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
    }

    public int getPersonalBookId() {
        return personalBookId;
    }

    public void setPersonalBookId(int personalBookId) {
        this.personalBookId = personalBookId;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Date getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public String getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(String borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public String getGetBookMessage() {
        return getBookMessage;
    }

    public void setGetBookMessage(String getBookMessage) {
        this.getBookMessage = getBookMessage;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String operatorReturnBook(){
        Map m = ActionContext.getContext().getSession();
        borrowHistoryItemList = service.queryBorrowHistoryItemByReturnCode(returnCode);
        if(borrowHistoryItemList == null || borrowHistoryItemList.size()==0){
            m.put("operatorReturnBookError","归还码不存在,请确认后再重新输入");
            return INPUT;
        }else if(borrowHistoryItemList.get(0).getBorrowStatus().trim().equals("请求归还")){
            //通过personalBookId查找PersonalBook
            personalBookId = borrowHistoryItemList.get(0).getPersonalBook().getPersonalBookId();
            personalBookList = service.queryPersonalBookByPersonalBookId(personalBookId);
            if(personalBookList == null || personalBookList.size() == 0){
                m.put("operatorReturnBookError","归还码无效");
                return INPUT;
            }else{
                if(personalBookList.get(0).getBookStatus().trim().equals("请求归还")||personalBookList.get(0).getBookStatus().trim().equals("请求索回")){
                    bookId = personalBookList.get(0).getBook().getBookId();
                    userId = borrowHistoryItemList.get(0).getBorrower().getUserId();
                    bookList = service.queryBookById(bookId);
                    userList = service.queryUserInfoByUserId(userId);
                    if(bookList == null || userList == null || bookList.size() == 0 || userList.size() == 0){
                        m.put("operatorReturnBookError","归还失败,该用户不存在或该书本信息不存在");
                        return INPUT;
                    }else {
                        m.put("operatorReturnBook", bookList);
                        m.put("operatorReturnUser", userList);
                        m.put("operatorReturnCode", returnCode);
                        return "confirm";
                    }
                }else{
                    m.put("operatorReturnBookError","归还码无效");
                    return INPUT;
                }
            }
        }else{
            m.put("operatorReturnBookError","归还码无效");
            return INPUT;
        }
    }

    public String operatorConfirmReturnBook() throws Exception{
        borrowHistoryItemList = service.queryBorrowHistoryItemByReturnCode(returnCode);
        personalBookId = borrowHistoryItemList.get(0).getPersonalBook().getPersonalBookId();
        personalBookList = service.queryPersonalBookByPersonalBookId(personalBookId);
        Map m = ActionContext.getContext().getSession();
        if(personalBookList.get(0).getGetBookCode()==null||personalBookList.get(0).getGetBookCode().trim().equals("")){
            bookStatus = "在库";
        }else {
            bookStatus = "请求索回";
            userId = personalBookList.get(0).getUser().getUserId();
            userList = service.queryUserInfoByUserId(userId);
            if(userList == null || userList.size() == 0){
                m.put("operatorReturnBookError","归还失败");
                return INPUT;
            }else{
                getBookMessage = "你的书已经在库,请及时来拿";
                MailUitls.sendMail(userList.get(0).getUserEmail(),getBookMessage);
            }
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String nowDate = df.format(new Date());
        actualReturnDate = df.parse(nowDate);
        borrowStatus = "已归还";
        borrowHistoryItemList.get(0).setBorrowStatus(borrowStatus);
        borrowHistoryItemList.get(0).setActualReturnDate(actualReturnDate);
        personalBookList.get(0).setBookStatus(bookStatus);
        if(service.updatePersonalBookAndBorrowHistoryItem(borrowHistoryItemList.get(0),personalBookList.get(0))){
            return SUCCESS;
        }else{
            m.put("operatorConfirmReturnBookError","归还失败");
            return INPUT;
        }
    }

    public void validateOperatorReturnBook(){
        Map m = ActionContext.getContext().getSession();
        if(returnCode.trim().equals("")){
            m.put("operatorReturnBookError","归还码不能为空");
            this.addFieldError("managerError","addErrorMessage");
        }
    }
}
