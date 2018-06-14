package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 查询图书
 * 2018/6/10
 */


public class QueryBookAction extends ActionSupport {
    private Book book;
    private List<Book> books;
    private List<Book> temp;
    private BookManagementServiceImpl service;

    public QueryBookAction(){

    }

    public BookManagementServiceImpl getService() {
        return service;
    }

    public void setService(BookManagementServiceImpl service) {
        this.service = service;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String queryBook(){
        List<String> list = new ArrayList();
        int size;
        if((book.getBookId()+"").trim().equals("")){
            temp=service.queryBookById(book.getBookId()+"");
        }else if(!book.getBookName().trim().equals("")){
            list.add("bookName");
            list.add(book.getBookName());
        }else if(!book.getBookAuthor().trim().equals("")){
            list.add("bookAuthor");
            list.add(book.getBookAuthor());
        }else if(!book.getBookPublish().trim().equals("")){
            list.add("bookPublish");
            list.add(book.getBookPublish());
        }else if(book.getBookPrice() > 0){
            list.add("bookPrice");
            list.add(book.getBookId()+"");
        }else if(!book.getBookCategory().trim().equals("")){
            list.add("bookCategory");
            list.add(book.getBookCategory());
        }

        size = list.size();

        switch(size){
            case 2:
                books=service.queryBook(list.get(0),list.get(1));
                break;
            case 4:
                books=service.queryBook(list.get(0),list.get(1),list.get(2),list.get(3));
                break;
            case 6:
                books=service.queryBook(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5));
                break;
            case 8:
                books=service.queryBook(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7));
                break;
            case 10:
                books=service.queryBook(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7),list.get(8),list.get(9));
                break;
            case 0:
                System.out.println("空");
                break;
                default :
                    System.out.println("其他");

        }

        if(size > 0){
            Map m = ActionContext.getContext().getSession();
            m.put("books",books);
            System.out.println(books.get(0).getBookAuthor());
            return SUCCESS;
        }else if(!(book.getBookId()+"").trim().equals("")){
            Map m = ActionContext.getContext().getSession();
            m.put("books",temp);

            return SUCCESS;
        }else{
            return INPUT;
        }


    }

}
