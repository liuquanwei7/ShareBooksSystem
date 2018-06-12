package com.sharebookssystem.bin.actions;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bin.dao.BookDao;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddBookAction extends ActionSupport{

    BookDao bd;
    User user;
    List<Book> books;
    String check_ISBN;
    String mybook;
    Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    //    String bookAuthor;
//    String bookName;

//    public String getBookAuthor() {
//        return bookAuthor;
//    }
//
//    public void setBookAuthor(String bookAuthor) {
//        this.bookAuthor = bookAuthor;
//    }
//
//    public String getBookName() {
//        return bookName;
//    }
//
//    public void setBookName(String bookName) {
//        this.bookName = bookName;
//    }
    //    String bookName;

//    public String getBookName() {
//        return bookName;
//    }
//
//    public void setBookName(String bookName) {
//        this.bookName = bookName;
//    }

//    public String[] getMybook() {
//        return mybook;
//    }
//
//    public void setMybook(String[] mybook) {
//        this.mybook = mybook;
//    }

    public String getMybook() {
        return mybook;
    }

    public void setMybook(String mybook) {
        this.mybook = mybook;
    }

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

    public void getJson(){
        System.out.println(mybook);
    }

    public String execute(){
        System.out.println("this is test");
//        System.out.println(mybook);
        //利用逗号分离字符串
        String []mybookdata=mybook.split(",");
        System.out.println(mybookdata[1]);
        book=new Book();
        book.setBookAuthor(mybookdata[1]);
        book.setBookName(mybookdata[0]);
        book.setBookPicture(mybookdata[2]);
        book.setBookPublish(mybookdata[3]);
        int endIndex = mybookdata[4].lastIndexOf("元");

        book.setBookPrice(Float.parseFloat(mybookdata[4].substring(0,endIndex)));
        book.setBookCategory(mybookdata[5]);

        System.out.println(book);
//        mybook=mybook.get(0).split(",");
//        System.out.println(bookAuthor);
//        String jsondata=Request
//        HttpServletRequest request= ServletActionContext.getRequest();
//        JSONObject json;
//        json=JSONObject.fromObject(request.getParameter("mybook"));
//        System.out.println(json);
//        JSONArray jsonArray = JSONArray.fromObject(mybook);
//        this.updValRecords = (List<ValRecordModel>)JSONArray.toList(jsonArray, ValRecordModel.class);
//        System.out.println(bookName);
//        Map map=ActionContext.getContext().getSession();
//        check_ISBN=(String) map.get("check_data");
//        map.put("check_data",null);

//        user=(User) map.get("user");
//        books=bd.checkBook(check_ISBN);
//        System.out.println(books.toString());
//        System.out.println(books.get(0).getBookName());
//        books=(List<Book>)mybook;
        if (book!=null){
            return SUCCESS;
        }else {
            return INPUT;
        }
    }
}
