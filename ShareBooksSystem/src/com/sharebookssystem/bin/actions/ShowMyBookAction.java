package com.sharebookssystem.bin.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bin.dao.BookDao;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.BookAllInfo;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;

import java.util.*;

public class ShowMyBookAction extends ActionSupport {
    List<Book> books;
    List<PersonalBook> personalbooks;
    User user;
    BookDao bd;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<PersonalBook> getPersonalbooks() {
        return personalbooks;
    }

    public void setPersonalbooks(List<PersonalBook> personalbooks) {
        this.personalbooks = personalbooks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookDao getBd() {
        return bd;
    }

    public void setBd(BookDao bd) {
        this.bd = bd;
    }

    public ShowMyBookAction(){

    }

    public String execute(){
        Map map=ActionContext.getContext().getSession();
//        check_data=(String) map.get("check_data");
//        map.put("check_data",null);
//        check_data="java";
        books=new ArrayList<Book>();
        personalbooks=new ArrayList<PersonalBook>();
//        user=(User) map.get("user");
        user=new User();

        user.setUserName("徒步浪");
        user.setUserPermission(2);
        user.setUserIdentity("15020225");
        user.setUserAccount("1239");
        user.setUserAge(24);
        user.setUserGender("男");
        user.setUserId(6);
        user.setUserPassword("1239");
//        books=bd.checkBook(check_data);
//        System.out.println(books.toString());
//        books.add((Book)bd.checkBook(check_data).get(0));
//        books=bd.checkBook(check_data);
        Collection result=new ArrayList();
        result=bd.checkMyBook(user.getUserId());//获取Collection对象
        if(result!=null) {
            ArrayList sList = (ArrayList) result;//转换类型
            Iterator iterator1 = sList.iterator();
            //遍历获取对应类的对象值
            while (iterator1.hasNext()) {
                Object[] o = (Object[]) iterator1.next();
                books.add((Book) o[0]);//获取book对象
                personalbooks.add((PersonalBook) o[1]);//获取personal Book对象
                System.out.println("BookInfo-Title: " + books.get(0).getBookAuthor());
                System.out.println("BookSelection-BookSelectionId: " + personalbooks.get(0).getBookStatus());
            }
//            bookAllInfo = new BookAllInfo();
//            bookAllInfo.setBooks(books);
//            bookAllInfo.setPersonalbooks(personalbooks);
            map.put("books", books);
            map.put("personalbooks", personalbooks);

//        books=(List<Book>)(Object[])a.get(0);
//        System.out.println(books.get(0).getBookName());
//        System.out.println(books);
        }
        if (books!=null&&personalbooks!=null){
            return SUCCESS;
        }else {
            return INPUT;
        }
    }
}
