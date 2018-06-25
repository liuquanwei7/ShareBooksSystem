package com.sharebookssystem.bin.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bin.dao.BookDao;
import com.sharebookssystem.bookUi.utils.MailUitls;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.BorrowHistoryItem;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BorrowBookAction extends ActionSupport {
    Book book;
    PersonalBook personalbook;
    User user;
    BorrowHistoryItem borrowHistoryItem=new BorrowHistoryItem();
    BookDao bd;
    List<PersonalBook> personalBooks;
    int personalBookId;

    public List<PersonalBook> getPersonalBooks() {
        return personalBooks;
    }

    public void setPersonalBooks(List<PersonalBook> personalBooks) {
        this.personalBooks = personalBooks;
    }

    public int getPersonalBookId() {
        return personalBookId;
    }

    public void setPersonalBookId(int personalBookId) {
        this.personalBookId = personalBookId;
    }

    public Book getBook() {
        return book;
    }

    public BorrowHistoryItem getBorrowHistoryItem() {
        return borrowHistoryItem;
    }

    public void setBorrowHistoryItem(BorrowHistoryItem borrowHistoryItem) {
        this.borrowHistoryItem = borrowHistoryItem;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public PersonalBook getPersonalbook() {
        return personalbook;
    }

    public void setPersonalbook(PersonalBook personalbook) {
        this.personalbook = personalbook;
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

    public BorrowBookAction(){

    }

    public String execute(){
        System.out.println("24323423");
//        user=(User)map.get("user");
        Map map=ActionContext.getContext().getSession();
//        personalBooks=(List<PersonalBook>)map.get("personalbooks");
        personalBooks=(List<PersonalBook>)map.get("personalbooks");
        System.out.print(personalBooks.get(0).getPersonalBookId());
        //找出对应个人图书信息
        for(int i=0;i<personalBooks.size();i++){
            if(personalBooks.get(i).getPersonalBookId()==personalBookId){
                personalbook=personalBooks.get(i);
            }
        }
        System.out.print(personalbook);
        System.out.println("this is personaltest22244");
//        user = new User();
//        System.out.println("this is personaltest1554");
//        //        mybook=new PersonalBook();
//        user.setUserName("徒步浪");
//        user.setUserPermission(2);
//        user.setUserIdentity("15020225");
//        user.setUserAccount("1239");
//        user.setUserAge(24);
//        user.setUserGender("男");
//        user.setUserId(6);
//        user.setUserPassword("1239");
//        user.setUserEmail("1053736438@qq.com");
        user=(User)map.get("user");
        System.out.println("this is personaltest144");
        personalbook.setBookStatus("请求借阅");
        borrowHistoryItem.setPersonalBook(personalbook);
        borrowHistoryItem.setBorrower(user);
        borrowHistoryItem.setBorrowStatus("请求借阅");

        System.out.println("this is personaltest11333");
//        System.out.println((int) ((Math.random() * 9 + 1) * 100000));
        int borrowCode=(int) ((Math.random() * 9 + 1) * 100000);
        map.put("borrowCode",borrowCode);
        borrowHistoryItem.setBorrowCode(borrowCode);
        if(bd.borrowBook(borrowHistoryItem)>0) {
            String code="您的借阅码为："+borrowHistoryItem.getBorrowCode()+";请持借阅码码找操作员借阅您选择的书籍";
            MailUitls.sendMail(user.getUserEmail(),code);
            System.out.println("this is personaltest111");
            return SUCCESS;
        }else{
            return INPUT;
        }
//            //        mybook.setUploadDate("null");
//            if (bd.addMyBook(mybook) > 0) {
//                jsonMap=new HashMap<String,Object>();
//                jsonMap.put("result","YES");
//                jsonMap.put("shareCode",mybook.getShareCode());
//
//                System.out.println("this is personaltest");
//                return SUCCESS;
//            } else {
//                jsonMap=new HashMap<String,Object>();
//                jsonMap.put("result","NO");
//                System.out.println("this is personaltest22");
//                return INPUT;
//            }
//        }else{
//            jsonMap=new HashMap<String,Object>();
//            jsonMap.put("result","NO");
//            return INPUT;
//        }
    }

}
