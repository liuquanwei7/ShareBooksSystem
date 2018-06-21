package com.sharebookssystem.bin.actions;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bin.dao.BookDao;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;
//import net.sf.json.JSONObject;
import net.sf.json.JSONObject;
import org.apache.struts2.json.annotations.JSON;
//import net.sf.json.JSON;
//import net.sf.json.JSONObject;


import java.util.HashMap;
import java.util.Map;

public class EnsureAddBookAction extends ActionSupport {
    Book book;
    BookDao bd;
    User user;
    PersonalBook mybook=new PersonalBook();
    Map<String,Object>jsonMap;
//    JSONObject theBook;

    public EnsureAddBookAction(){

    }

    public Map<String, Object> getJsonMap() {
        return jsonMap;
    }

    public void setJsonMap(Map<String, Object> jsonMap) {
        this.jsonMap = jsonMap;
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

    public String execute() throws Exception{
//        book=(Book)JSONObject.toBean(theBook,Book.class);
//        Map map=ActionContext.getContext().getSession();
        System.out.println("24323423");
//        user=(User)map.get("user");
        if(bd.addBook(book)>0) {
            System.out.println("this is personaltest22244");
            user = new User();
            System.out.println("this is personaltest1554");
            //        mybook=new PersonalBook();
            user.setUserName("徒步浪");
            user.setUserPermission(2);
            user.setUserIdentity("15020225");
            user.setUserAccount("1239");
            user.setUserAge(24);
            user.setUserGender("男");
            user.setUserId(6);
            user.setUserPassword("1239");
            System.out.println("this is personaltest144");
            mybook.setBook(book);
            mybook.setUser(user);
            mybook.setBookStatus("申请分享");
            mybook.setNumberOfTimes(0);
            System.out.println("this is personaltest11333");
            System.out.println((int) ((Math.random() * 9 + 1) * 100000));
            mybook.setShareCode((int) ((Math.random() * 9 + 1) * 100000));
            System.out.println("this is personaltest111");

            //        mybook.setUploadDate("null");
            if (bd.addMyBook(mybook) > 0) {
                jsonMap=new HashMap<String,Object>();
                jsonMap.put("result","YES");
                jsonMap.put("shareCode",mybook.getShareCode());

                System.out.println("this is personaltest");
                return SUCCESS;
            } else {
                jsonMap=new HashMap<String,Object>();
                jsonMap.put("result","NO");
                System.out.println("this is personaltest22");
                return INPUT;
            }
        }else{
            jsonMap=new HashMap<String,Object>();
            jsonMap.put("result","NO");
            return INPUT;
        }
    }

}
