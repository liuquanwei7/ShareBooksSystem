package com.sharebookssystem.bin.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bin.dao.BookDao;
import com.sharebookssystem.bookUi.utils.MailUitls;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;

import java.util.List;
import java.util.Map;

public class GetMyBookAction extends ActionSupport {
    List<PersonalBook>personalBooks;
    PersonalBook personalbook;
    int personalBookId;
    BookDao bd;
    User user;

    public GetMyBookAction(){

    }
    public List<PersonalBook> getPersonalBooks() {
        return personalBooks;
    }

    public void setPersonalBooks(List<PersonalBook> personalBooks) {
        this.personalBooks = personalBooks;
    }

    public PersonalBook getPersonalbook() {
        return personalbook;
    }

    public void setPersonalbook(PersonalBook personalbook) {
        this.personalbook = personalbook;
    }

    public int getPersonalBookId() {
        return personalBookId;
    }

    public void setPersonalBookId(int personalBookId) {
        this.personalBookId = personalBookId;
    }

    public BookDao getBd() {
        return bd;
    }

    public void setBd(BookDao bd) {
        this.bd = bd;
    }

    public String execute(){
        System.out.println("24323423");
//
        Map map=ActionContext.getContext().getSession();
        user=(User)map.get("user");
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
//        System.out.println("this is personaltest22244");
//        user = new User();
//        System.out.println("this is personaltest1554");
//        //        mybook=new PersonalBook();
//        user=new User();
//        user.setUserName("徒步浪");
//        user.setUserPermission(2);
//        user.setUserIdentity("15020225");
//        user.setUserAccount("1239");
//        user.setUserAge(24);
//        user.setUserGender("男");
//        user.setUserId(6);
//        user.setUserPassword("1239");
//        user.setUserEmail("1053736438@qq.com");
//        System.out.println("this is personaltest144");
//        borrowHistoryItem.setPersonalBook(personalbook);
//        borrowHistoryItem.setBorrower(user);
//        borrowHistoryItem.setBorrowStatus("请求借阅");

        System.out.println("this is personaltest11333");
//        System.out.println((int) ((Math.random() * 9 + 1) * 100000));
        int getBookCode1=(int) ((Math.random() * 9 + 1) * 100000);
        String getBookCode=getBookCode1+"";
        map.put("getBookCode",getBookCode);
        personalbook.setGetBookCode(getBookCode);
        personalbook.setBookStatus("请求索回");

        if(bd.getMyBook(personalbook)) {
            String code="您的索回码为："+personalbook.getGetBookCode()+";请持索回码找操作员拿回您的书籍";
            MailUitls.sendMail(user.getUserEmail(),code);
            System.out.println("this is personaltest111");
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}
