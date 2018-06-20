package com.sharebookssystem.bin.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bin.dao.BookDao;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.PersonalBook;

import java.util.List;
import java.util.Map;

public class ShowBookInfoAction extends ActionSupport {
    Book mybook;//选中的图书
    List<Book> books;
    BookDao bd;
    List<PersonalBook> personalBooks;//session中的图书
    PersonalBook personalBook;//选中的图书
    int bookId;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        books = books;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public PersonalBook getPersonalBook() {
        return personalBook;
    }

    public void setPersonalBook(PersonalBook personalBook) {
        this.personalBook = personalBook;
    }

    public List<PersonalBook> getPersonalBooks() {
        return personalBooks;
    }

    public void setPersonalBooks(List<PersonalBook> personalBooks) {
        this.personalBooks = personalBooks;
    }

    public Book getMybook() {
        return mybook;
    }

    public void setMybook(Book mybook) {
        this.mybook = mybook;
    }

    public BookDao getBd() {
        return bd;
    }

    public void setBd(BookDao bd) {
        this.bd = bd;
    }

    public ShowBookInfoAction(){

    }

    public String execute()throws Exception{
        Map map=ActionContext.getContext().getSession();
        personalBooks=(List<PersonalBook>)map.get("personalbooks");
        books=(List<Book>)map.get("books");
        for(int i=0;i<books.size();i++){
            if(bookId==books.get(i).getBookId()){
                mybook=books.get(i);
            }
        }
        //找出对应个人图书信息
        for(int i=0;i<personalBooks.size();i++){
            if(personalBooks.get(i).getBook().getBookId()==mybook.getBookId()){
                personalBook=personalBooks.get(i);
            }
        }
        System.out.print(mybook.getBookCategory());
        if(personalBook!=null){
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}
