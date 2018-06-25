package com.sharebookssystem.bin.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bin.dao.CarDao;
import com.sharebookssystem.model.CollectCarItem;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;

import java.util.List;
import java.util.Map;

public class AddBookToCarAction extends ActionSupport {
    CarDao cd;
    CollectCarItem collectCarItem=new CollectCarItem();
    User user;
    PersonalBook personalBook;
    List<PersonalBook> personalBooks;
    int personalBookId;
    public AddBookToCarAction(){

    }

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

    public CarDao getCd() {
        return cd;
    }

    public void setCd(CarDao cd) {
        this.cd = cd;
    }

    public CollectCarItem getCollectCarItem() {
        return collectCarItem;
    }

    public void setCollectCarItem(CollectCarItem collectCarItem) {
        this.collectCarItem = collectCarItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PersonalBook getPersonalBook() {
        return personalBook;
    }

    public void setPersonalBook(PersonalBook personalBook) {
        this.personalBook = personalBook;
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
                personalBook=personalBooks.get(i);
            }
        }
        System.out.print(personalBook);
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
//        System.out.println("this is personaltest144");
//        user=(User) map.get("user");
        collectCarItem.setPersonalBook(personalBook);
        collectCarItem.setUser(user);
//        collectCarItem.setBorrowStatus("请求借阅");

        System.out.println("this is personaltest11333");
//        System.out.println((int) ((Math.random() * 9 + 1) * 100000));
//        int borrowCode=(int) ((Math.random() * 9 + 1) * 100000);
//        map.put("borrowCode",borrowCode);
//        borrowHistoryItem.setBorrowCode(borrowCode);
        if(cd.addInCar(collectCarItem)>0) {

            System.out.println("this is personaltest111");
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}
