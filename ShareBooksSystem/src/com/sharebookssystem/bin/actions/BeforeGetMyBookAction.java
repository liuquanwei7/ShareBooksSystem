package com.sharebookssystem.bin.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bin.dao.BookDao;
import com.sharebookssystem.bookUi.utils.MailUitls;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;

import java.util.*;

public class BeforeGetMyBookAction extends ActionSupport {
    List<PersonalBook> personalBooks;
    PersonalBook personalbook;
    int personalBookId;
    BookDao bd;
    List<User> users;
    List<Book>books;
    Book book;
    User user;

    public BeforeGetMyBookAction(){

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
//        user=(User)map.get("user");
        Map map=ActionContext.getContext().getSession();
//        personalBooks=(List<PersonalBook>)map.get("personalbooks");
        personalBooks=(List<PersonalBook>)map.get("personalbooks");
        books=(List<Book>)map.get("books");
        System.out.print(personalBooks.get(0).getPersonalBookId());

//        bd.checkEmail(personalBookId)
        users=new ArrayList<User>();
        Collection result=new ArrayList();
        result=bd.checkEmail(personalBookId);//获取Collection对象
        if(result!=null) {
            ArrayList sList = (ArrayList) result;//转换类型
            Iterator iterator1 = sList.iterator();
            //遍历获取对应类的对象值
            while (iterator1.hasNext()) {
                Object[] o = (Object[]) iterator1.next();
                System.out.println(o);
                System.out.println(o[0]);
                System.out.println(o[1]);
                System.out.println(o[2]);
//                System.out.println(o[0]);

                users.add((User) o[2]);//获取book对象
//                personalbooks.add((PersonalBook) o[1]);//获取personal Book对象
//                System.out.println("BookInfo-Title: " + books.get(0).getBookAuthor());
                System.out.println("BookSelection-BookSelectionId: " + users.get(0).getUserEmail());
            }
//            bookAllInfo = new BookAllInfo();
//            bookAllInfo.setBooks(books);
//            bookAllInfo.setPersonalbooks(personalbooks);
//            map.put("books", books);
//            map.put("personalbooks", personalbooks);

//        books=(List<Book>)(Object[])a.get(0);
//        System.out.println(books.get(0).getBookName());
//        System.out.println(books);
        }

        //找出对应个人图书信息
        for(int i=0;i<personalBooks.size();i++){
            if(personalBooks.get(i).getPersonalBookId()==personalBookId){
                personalbook=personalBooks.get(i);
            }
        }
        for(int i=0;i<books.size();i++){
            if(personalbook.getBook().getBookId()==books.get(i).getBookId()){
                book=books.get(i);
            }
        }
        String codeinfo="该书分享者急需您借阅的《"+book.getBookName()+"》请及时归还！！！";
        MailUitls.sendMail(users.get(0).getUserEmail(),codeinfo);
        System.out.print(personalbook);
//        System.out.println("this is personaltest22244");


        System.out.println("this is personaltest11333");
//        System.out.println((int) ((Math.random() * 9 + 1) * 100000));
        int getBookCode1=(int) ((Math.random() * 9 + 1) * 100000);
        String getBookCode=getBookCode1+"";
        map.put("getBookCode",getBookCode);
        personalbook.setGetBookCode(getBookCode);
        if(bd.getMyBook(personalbook)) {
            user=new User();
            user.setUserName("徒步浪");
            user.setUserPermission(2);
            user.setUserIdentity("15020225");
            user.setUserAccount("1239");
            user.setUserAge(24);
            user.setUserGender("男");
            user.setUserId(6);
            user.setUserPassword("1239");
            user.setUserEmail("1053736438@qq.com");
//            user=(User)map.get("user");
            String code="您的索回码为："+personalbook.getGetBookCode()+";请等待图书归还在库后持改索回码找操作员拿回您的书籍";
            MailUitls.sendMail(user.getUserEmail(),code);
            System.out.println("this is personaltest111");
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}
