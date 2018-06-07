package com.sharebookssystem.bin.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bin.dao.BookDao;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.User;

import java.util.List;
import java.util.Map;

public class AddBookAction extends ActionSupport{

    BookDao bd;
    User user;
    List<Book> books;
    String check_ISBN;

    public AddBookAction(){}

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

    public String getCheck_ISBN() {
        return check_ISBN;
    }

    public void setCheck_ISBN(String check_ISBN) {
        this.check_ISBN = check_ISBN;
    }

    public BookDao getBd() {
        return bd;
    }

    public void setBd(BookDao bd) {
        this.bd = bd;
    }

    public String execute(){
        Map map=ActionContext.getContext().getSession();
//        check_ISBN=(String) map.get("check_data");
//        map.put("check_data",null);
        user=(User) map.get("user");
        books=bd.checkBook(check_ISBN);
        System.out.println(books.toString());
        System.out.println(books.get(0).getBookName());
        if (books!=null){
            return SUCCESS;
        }else {
            return INPUT;
        }
    }
}
