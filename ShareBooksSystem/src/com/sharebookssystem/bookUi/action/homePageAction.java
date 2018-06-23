package com.sharebookssystem.bookUi.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.bookUi.dao.BookDao;
import com.sharebookssystem.bookUi.dao.BorrowHistoryItemDao;
import com.sharebookssystem.bookUi.dao.PersonalBookDao;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.BorrowHistoryItem;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;

import java.util.List;
import java.util.Map;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class homePageAction {
    BorrowHistoryItem borrowHistoryItem;
    BorrowHistoryItemDao borrowHistoryItemDao;
    Book book;
    BookDao bd;
    List<Book> books;
    PersonalBook personalBook;
    PersonalBookDao personalBookDao;
    List<PersonalBook> personalBooks;

    public BorrowHistoryItem getBorrowHistoryItem() {
        return borrowHistoryItem;
    }

    public void setBorrowHistoryItem(BorrowHistoryItem borrowHistoryItem) {
        this.borrowHistoryItem = borrowHistoryItem;
    }

    public BorrowHistoryItemDao getBorrowHistoryItemDao() {
        return borrowHistoryItemDao;
    }

    public void setBorrowHistoryItemDao(BorrowHistoryItemDao borrowHistoryItemDao) {
        this.borrowHistoryItemDao = borrowHistoryItemDao;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookDao getBd() {
        return bd;
    }

    public void setBd(BookDao bd) {
        this.bd = bd;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public PersonalBook getPersonalBook() {
        return personalBook;
    }

    public void setPersonalBook(PersonalBook personalBook) {
        this.personalBook = personalBook;
    }

    public PersonalBookDao getPersonalBookDao() {
        return personalBookDao;
    }

    public void setPersonalBookDao(PersonalBookDao personalBookDao) {
        this.personalBookDao = personalBookDao;
    }

    public List<PersonalBook> getPersonalBooks() {
        return personalBooks;
    }

    public void setPersonalBooks(List<PersonalBook> personalBooks) {
        this.personalBooks = personalBooks;
    }

    public String execute() throws Exception{
        ActionContext ac=ActionContext.getContext();
        //	Map map=ActionContext.getContext().getSession();
        //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
        //拿到表示request对象 的map
        Map<String, Object> request=ac.getContextMap();
        Map<String, Object> session=ac.getSession();
        borrowHistoryItemDao.queryPages();
        books= (List<Book>)session.get("books");
        System.out.println("检查books"+books.get(0).getBookName());
        personalBooks=(List<PersonalBook>) session.get("personalbooks");
        System.out.println("检查Personalbooks"+personalBooks.get(0).getBookStatus());
        return SUCCESS;

    }

}
