package com.sharebookssystem.bookUi.action;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.bookUi.dao.BookDao;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;

import java.util.Map;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class queryReturnActionById {
    Book book;
    int id;
    BookDao bd=new BookDao();
    User user;
    PersonalBook pb;

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

    public BookDao getBd() {
        return bd;
    }

    public void setBd(BookDao bd) {
        this.bd = bd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PersonalBook getPb() {
        return pb;
    }

    public void setPb(PersonalBook pb) {
        this.pb = pb;
    }
    public String execute() throws Exception{
        ActionContext ac=ActionContext.getContext();
        //	Map map=ActionContext.getContext().getSession();
        //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
        //拿到表示request对象 的map
        Map<String, Object> request=ac.getContextMap();
        Map<String, Object> session=ac.getSession();

           user=(User)session.get("user");
           int userid=user.getUserId();
           System.out.println("userid::"+userid);
           if(bd.queryReturnActionById(pb,userid,id)){


            return SUCCESS;
        }
        session.put("ReturnSuccess","还书失败");
        return INPUT;
    }
}
