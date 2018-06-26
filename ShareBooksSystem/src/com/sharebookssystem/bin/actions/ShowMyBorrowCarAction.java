package com.sharebookssystem.bin.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sharebookssystem.bin.dao.CarDao;
import com.sharebookssystem.model.*;

import java.util.*;

public class ShowMyBorrowCarAction extends ActionSupport {
    CarDao cd;
    User user;
    List<Book> books;
    List<PersonalBook> personalbooks;
    List<CollectCarItem> collectCarItems;

    int pageNo=1;
    final int pageSize=4;
    int currentPage;
    int totalPage;

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

    public ShowMyBorrowCarAction(){

    }

    public CarDao getCd() {
        return cd;
    }

    public void setCd(CarDao cd) {
        this.cd = cd;
    }

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

    public List<PersonalBook> getPersonalbooks() {
        return personalbooks;
    }

    public void setPersonalbooks(List<PersonalBook> personalbooks) {
        this.personalbooks = personalbooks;
    }

    public List<CollectCarItem> getCollectCarItems() {
        return collectCarItems;
    }

    public void setCollectCarItems(List<CollectCarItem> collectCarItems) {
        this.collectCarItems = collectCarItems;
    }

    public String execute(){
        Map map=ActionContext.getContext().getSession();
//        check_data=(String) map.get("check_data");
//        map.put("check_data",null);
//        check_data="java";
        books=new ArrayList<Book>();
        personalbooks=new ArrayList<PersonalBook>();
        user=(User) map.get("user");
//        user=new User();
////
//        user.setUserName("徒步浪");
//        user.setUserPermission(2);
//        user.setUserIdentity("15020225");
//        user.setUserAccount("1239");
//        user.setUserAge(24);
//        user.setUserGender("男");
//        user.setUserId(6);
//        user.setUserPassword("1239");
//        books=bd.checkBook(check_data);
//        System.out.println(books.toString());
//        books.add((Book)bd.checkBook(check_data).get(0));
//        books=bd.checkBook(check_data);
        Collection result=new ArrayList();
        result=cd.checkMyBorrowCar(user.getUserId());//获取Collection对象

        if(result.size()%pageSize==0){
            totalPage=result.size()/pageSize;
        }else{
            totalPage=result.size()/pageSize+1;
        }
        //判断上一页下一页
        if(pageNo<=0){
            pageNo=1;
        }else if (pageNo>totalPage){
            pageNo=totalPage;
        }
        //设置当前页
        currentPage=pageNo;
        System.out.println(totalPage+"fsdfa33");
        System.out.println(pageNo+"fsdfa11");
        System.out.println(pageSize+"fsdfa55");
//        air_tickets=td.queryTimeOrNameByPage(query_data,user.getId(),
//                pageNo,pageSize);
        result=cd.checkMyBorrowCarByPage(user.getUserId(),pageNo,pageSize);


        if(result!=null) {
            ArrayList sList = (ArrayList) result;//转换类型
            Iterator iterator1 = sList.iterator();
            //遍历获取对应类的对象值
            while (iterator1.hasNext()) {
                Object[] o = (Object[]) iterator1.next();
                System.out.println(o);
                books.add((Book) o[0]);//获取book对象
                personalbooks.add((PersonalBook) o[1]);//获取personal Book对象
//                collectCarItems.add((CollectCarItem) o[2]);//获取personal Book对象
                System.out.println("BookInfo-Title: " + books.get(0).getBookAuthor());
                System.out.println("BookSelection-BookSelectionId: " + personalbooks.get(0).getBookStatus());
//                System.out.println("BookSelection-BookSelectionId: " + collectCarItems.get(0).getCollectCarItemId());
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
        if (books!=null&&personalbooks!=null){
            return SUCCESS;
        }else {
            return INPUT;
        }
    }
}
