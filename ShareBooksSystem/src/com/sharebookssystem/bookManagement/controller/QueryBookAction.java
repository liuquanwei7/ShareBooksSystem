package com.sharebookssystem.bookManagement.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bookManagement.service.impl.BookManagementServiceImpl;
import com.sharebookssystem.model.Book;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 查询图书
 * 2018/6/10
 */


public class QueryBookAction extends ActionSupport {
    private Book book;
    private List<Book> books = new ArrayList<>();
    private List<Book> temp = new ArrayList<>();
    private BookManagementServiceImpl service;
    private int id; //界面显示数据的索引
    private int pageNo=1; //计数器,从第1页开始显示
    private int currentPage; //当前页
    private int totalPage; //总页数

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }


    public String queryBook(){
        Map m = ActionContext.getContext().getSession();
        m.put("managerBooks","");
        List list = new ArrayList();
        if(book!=null){
            m.put("managerBookTemp",book);
        }else{
            return INPUT;
        }

        if(book.getBookId()>0){
            list.add(book.getBookId());
        }else {
            if(!book.getBookName().trim().equals("")){
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
                list.add(book.getBookPrice());
            }else if(!book.getBookCategory().trim().equals("")){
                list.add("bookCategory");
                list.add(book.getBookCategory());
            }else {

            }
            m.put("managerBookTempList",list);  //分页查询
        }


        if(book.getBookId()!=0){    //如果有bookId直接查询
            temp=service.queryBookById(book.getBookId());
            if(temp==null||temp.size()==0){
                if(m.get("managerQueryNoBookError")==null&&m.get("managerQueryLowPriceError")==null){
                    m.put("managerQueryNullError","抱歉,没有查到相关的图书,请输入正确的图书信息");
                }
                return INPUT;
            }else{
                m.put("managerBookTempList",list);  //分页查询只有bookId
                m.put("managerBooks",temp);     //jsp页面迭代显示
                m.put("managerBookShow","1");   //显示判断
                return SUCCESS;
            }
        }else if(list.size() > 0){
            books = service.queryBook(list,pageNo);
            if(books==null){
                if(m.get("managerQueryNoBookError")==null&&m.get("managerQueryLowPriceError")==null){
                    m.put("managerQueryNullError","抱歉,没有查到相关的图书,请输入正确的图书信息");
                }
                return INPUT;
            }else{
                currentPage=1;
                totalPage=(Integer)m.get("managerTotalPage");
                m.put("managerBooks",books);
                m.put("managerBookShow","1");
                return SUCCESS;
            }
        }else{
            if(m.get("managerQueryNoBookError")==null&&m.get("managerQueryLowPriceError")==null){
                m.put("managerQueryNullError","抱歉,没有查到相关的图书,请输入正确的图书信息");
            }
            return INPUT;
        }

    }


    public void validateQueryBook(){
        Map s = ActionContext.getContext().getSession();
        if(book.getBookId()<1&&book.getBookName().trim().equals("")&&book.getBookAuthor().trim().equals("")&&book.getBookPublish().trim().equals("")&&book.getBookPrice()==0&&book.getBookCategory().trim().equals("")){
            s.put("managerQueryNoBookError","不能为空，至少填一项！");
            this.addFieldError("managerError","addErrorMessage");
        }else{
            if(book.getBookPrice()<0){
                s.put("managerQueryLowPriceError","价格不能小于0元");
                this.addFieldError("managerError","addErrorMessage");
            }
        }
    }

}
