package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.BorrowHistoryItem;
import com.sharebookssystem.model.PersonalBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 删除图书
 * 2018/6/10
 */


public class DeleteBookAction extends ActionSupport {
    private List<Book> bookList = new ArrayList<>();
    private List<PersonalBook> personalBookList = new ArrayList<>();
    private List<BorrowHistoryItem> borrowHistoryItemList = new ArrayList<>();
    private Book book;
    private PersonalBook personalBook;
    private BorrowHistoryItem borrowHistoryItem;
    private int bookId;
    private int personalBookId;
    private BookManagementServiceImpl service;

    public DeleteBookAction(){

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public BorrowHistoryItem getBorrowHistoryItem() {
        return borrowHistoryItem;
    }

    public void setBorrowHistoryItem(BorrowHistoryItem borrowHistoryItem) {
        this.borrowHistoryItem = borrowHistoryItem;
    }

    public int getPersonalBookId() {
        return personalBookId;
    }

    public void setPersonalBookId(int personalBookId) {
        this.personalBookId = personalBookId;
    }

    public PersonalBook getPersonalBook() {
        return personalBook;
    }

    public void setPersonalBook(PersonalBook personalBook) {
        this.personalBook = personalBook;
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
        bookList = service.queryBookById(bookId);
        Map m = ActionContext.getContext().getSession();
        m.put("managerDeleteBookItem",bookList);
        return "confirm";
    }

    public String confirmDeleteBook(){
        Map m = ActionContext.getContext().getSession();
        bookList = service.queryBookById(bookId);
        if(bookList==null||bookList.size()==0){
            m.put("managerDeleteBookError","删除失败，没有查询到该条数据");
            return INPUT;
        }else{
            book = bookList.get(0);
            personalBookList = service.queryPersonalBook(bookId);
            if(personalBookList.size()==0||personalBookList==null){
                //只有bookInfo有数据
                if(service.deleteBook(bookId)){
                    return SUCCESS;
                }else{
                    m.put("managerDeleteBookError","删除失败");
                    return INPUT;
                }
            }else{
                personalBook = personalBookList.get(0);
                personalBookId = personalBook.getPersonalBookId();
                if(service.deleteCollectCarItem(personalBookId)&&service.deleteCommentItem(personalBookId)&&service.deleteBorrowHistoryItem(personalBookId)&&service.deletePersonalBook(personalBookId)){
                    //删除关联表
                    if(service.deleteBook(bookId)){
                        return SUCCESS;
                    }else{
                        m.put("managerDeleteBookError","删除失败");
                        return INPUT;
                    }
                }else{
                    m.put("managerDeleteBookError","删除失败");
                    return INPUT;
                }
            }

        }

    }
}
