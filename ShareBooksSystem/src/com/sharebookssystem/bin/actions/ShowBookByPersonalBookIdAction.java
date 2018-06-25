package com.sharebookssystem.bin.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bin.dao.BookDao;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.BookAllInfo;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;

import java.util.*;

public class ShowBookByPersonalBookIdAction extends ActionSupport {
    BookDao bd;
    User user;
    List<Book> books;
    List<PersonalBook> personalbooks;
    List oj;
    String check_data;
//    BookAllInfo bookAllInfo;
    int personalBookId;
    Book mybook;//选中的图书
    PersonalBook personalBook;

    int pageNo=1;
    final int pageSize=1;
    int currentPage;
    int totalPage;

    public Book getMybook() {
        return mybook;
    }

    public void setMybook(Book mybook) {
        this.mybook = mybook;
    }

    public PersonalBook getPersonalBook() {
        return personalBook;
    }

    public void setPersonalBook(PersonalBook personalBook) {
        this.personalBook = personalBook;
    }

    public int getPersonalBookId() {
        return personalBookId;
    }

    public void setPersonalBookId(int personalBookId) {
        this.personalBookId = personalBookId;
    }

    public List getOj() {
        return oj;
    }

    public void setOj(List oj) {
        this.oj = oj;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
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

    public List<PersonalBook> getPersonalbooks() {
        return personalbooks;
    }

    public void setPersonalbooks(List<PersonalBook> personalbooks) {
        this.personalbooks = personalbooks;
    }

//    public BookAllInfo getBookAllInfo() {
//        return bookAllInfo;
//    }
//
//    public void setBookAllInfo(BookAllInfo bookAllInfo) {
//        this.bookAllInfo = bookAllInfo;
//    }

    public List<PersonalBook> getOwnbooks() {
        return personalbooks;
    }

    public void setOwnbooks(List<PersonalBook> personalbooks) {
        this.personalbooks = personalbooks;
    }

    public ShowBookByPersonalBookIdAction(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getCheck_data() {
        return check_data;
    }

    public void setCheck_data(String check_data) {
        this.check_data = check_data;
    }

    public BookDao getBd() {
        return bd;
    }

    public void setBd(BookDao bd) {
        this.bd = bd;
    }

    public String execute(){
        Map map=ActionContext.getContext().getSession();
//        check_data=(String) map.get("check_data");
//        map.put("check_data",null);
//        check_data="java";
        books=new ArrayList<Book>();
        personalbooks=new ArrayList<PersonalBook>();
        user=(User) map.get("user");
//        books=bd.checkBook(check_data);
//        System.out.println(books.toString());
//        books.add((Book)bd.checkBook(check_data).get(0));
//        books=bd.checkBook(check_data);
        Collection result=new ArrayList();
        books=null;
        personalbooks=null;
        result=bd.checkBookByPersonalId(personalBookId);//获取Collection对象

//        if(result.size()%pageSize==0){
//            totalPage=result.size()/pageSize;
//        }else{
//            totalPage=result.size()/pageSize+1;
//        }
//        //判断上一页下一页
//        if(pageNo<=0){
//            pageNo=1;
//        }else if (pageNo>totalPage){
//            pageNo=totalPage;
//        }
//        //设置当前页
//        currentPage=pageNo;
//        System.out.println(totalPage+"fsdfa33");
//        System.out.println(pageNo+"fsdfa11");
//        System.out.println(pageSize+"fsdfa55");
////        air_tickets=td.queryTimeOrNameByPage(query_data,user.getId(),
////                pageNo,pageSize);
//        result=bd.checkBookByPage(check_data,pageNo,pageSize);

        if(result!=null) {
            books=new ArrayList<Book>();
            personalbooks=new ArrayList<PersonalBook>();
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
            personalBook=personalbooks.get(0);
            mybook=books.get(0);
            return SUCCESS;
        }else {
            return INPUT;
        }
    }
}
