package com.sharebookssystem.bin.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bin.dao.BookDao;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.User;
import org.hibernate.cache.spi.CacheKey;

//import java.awt.print.Book;
import java.util.List;
import java.util.Map;

public class CheckBookAction extends ActionSupport {
    BookDao bd;
    User user;
    List<Book> books;
    String check_data;

    public CheckBookAction(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getCheck_data() {
        return check_data;
    }

    public void setCheck_data(String check_data) {
        this.check_data = check_data;
    }

    public BookDao getBd() {
        return bd;
    }

    public void setBd(BookDao bd) {
        this.bd = bd;
    }

    public String execute(){
        Map map=ActionContext.getContext().getSession();
        check_data=(String) map.get("check_data");
        user=(User) map.get("user");
        books=bd.checkBook(check_data);
        System.out.println(books.toString());
        System.out.println(books.get(0).getBookName());
        if (books!=null){
            return SUCCESS;
        }else {
            return INPUT;
        }
    }
}
