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

public class borrowShowAction {
    User user;
    Book book;
    BookDao bd;
    BorrowHistoryItem borrowHistoryItem;
    BorrowHistoryItemDao bI;
    PersonalBook pb;
    PersonalBookDao pbd;
    int userid;
    String personid;
    String bookid;
    List<Book> books;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public BorrowHistoryItem getBorrowHistoryItem() {
        return borrowHistoryItem;
    }

    public void setBorrowHistoryItem(BorrowHistoryItem borrowHistoryItem) {
        this.borrowHistoryItem = borrowHistoryItem;
    }

    public BorrowHistoryItemDao getbI() {
        return bI;
    }

    public void setbI(BorrowHistoryItemDao bI) {
        this.bI = bI;
    }

    public PersonalBook getPb() {
        return pb;
    }

    public void setPb(PersonalBook pb) {
        this.pb = pb;
    }

    public PersonalBookDao getPbd() {
        return pbd;
    }

    public void setPbd(PersonalBookDao pbd) {
        this.pbd = pbd;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String execute() throws Exception{

        ActionContext ac=ActionContext.getContext();
        //	Map map=ActionContext.getContext().getSession();
        //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
        //拿到表示request对象 的map
        Map<String, Object> request=ac.getContextMap();
        Map<String, Object> session=ac.getSession();
        session.remove("pdarray");
        session.remove("books");
        session.remove("mounts");
        user=(User)session.get("user");
        userid=(Integer) user.getUserId();

        if(bI.queryPersonalId(borrowHistoryItem,userid)==null){
           session.put("ReturnSuccess","没有借书记录");
            return INPUT;
        }
        if(pbd.queryBookId(pb)==null){
            session.put("ReturnSuccess","没有借书记录");
            return INPUT;
        }

        if(bd.queryBooks(book)==null){
            session.put("ReturnSuccess","没有借书记录");
            return INPUT;
        }
        books=bd.queryBooks(book);

        return SUCCESS;

    }
}
