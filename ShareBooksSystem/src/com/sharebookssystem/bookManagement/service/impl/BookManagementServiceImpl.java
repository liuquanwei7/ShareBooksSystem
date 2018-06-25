package com.sharebookssystem.bookManagement.service.impl;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.bookManagement.dao.hibernate.BookManagementDaoImpl;
import com.sharebookssystem.bookManagement.service.BookManagementService;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.Manager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 实现类
 * 2018/6/5
 */


public class BookManagementServiceImpl implements BookManagementService {
    private static final String bookClassName = "Book";
    private static final String bookParam0 = "bookId";
    private static final String managerClassName = "Manager";
    private static final String managerParam0 = "managerId";
    private static final String managerParam1 = "managerAccount";
    private static final String managerParam2 = "managerPassword";
    private static final String managerParam6 = "managerPermission";
    private static final String personalBookClassName = "PersonalBook";
    private static final String personalBookParam2 = "bookId";
    private static final String borrowHistoryItemClassName = "BorrowHistoryItem";
    private static final String personalBookParam1 = "personalBookId";
    private static final String collectCarItemClassName = "CollectCarItem";
    private static final String commentItemClassName = "CommentItem";
    private static final String personalBookParam6 = "shareCode";
    private static final String personalBookParam8 = "getBookCode";
    private static final String borrowHistoryItemParam7 = "borrowCode";
    private static final String getBorrowHistoryItemParam8 = "returnCode";
    private static final String userClassName = "User";
    private static final String userParam0 = "userId";
    private int totalPage; //总页数
    private List<Book> books;
    private List result = new ArrayList();  //返回查询图书的结果
    private List allBooks;  //查出来的所有书
    private List allManager; //查询出来的所有管理员
    private final int pageSize=5; //每页显示记录的个数
    private int pageNo=1; //计数器,从第1页开始显示
    private int showItems; //要显示的条数
    private int lastSize; //最后一页的大小
    private int firstNo; //第一条数据的位置

    private BookManagementDaoImpl dao;

    public BookManagementServiceImpl() {

    }

    public BookManagementDaoImpl getDao() {
        return dao;
    }

    public void setDao(BookManagementDaoImpl dao) {
        this.dao = dao;
    }


    //判断管理员账户是否存在
    public boolean isExistManager(String managerAccount,String managerPassword,int managerPermission){
        List<Object> result = dao.queryByParam(managerClassName,managerParam1,managerAccount,managerParam2,managerPassword,managerParam6,managerPermission);
        if(result.size()>0){
            return true;
        }else {
            return false;
        }
    }

    //注册管理员账户
    public boolean registerManager(Object object){
        return dao.updateByObject(object);
    }

    //判断注册管理员账号是否重复
    public boolean isSameAccount(String managerAccount){
        List list1 = new ArrayList();
        list1 = dao.queryByParam(managerClassName,managerParam1,managerAccount);
        if(list1.size()==0||list1==null){
            return true;
        }else {
            return false;
        }
    }

    //修改管理员信息
    public boolean updateManagerInfo(Object object){
        return dao.updateByObject(object);
    }

    //删除管理员信息
    public boolean deleteManagerIno(int id){
        return  dao.deleteByHql(managerClassName,managerParam0,id);
    }

    //更新管理员密码
    public boolean updateManagerPassword(Object object){
        return dao.updateByObject(object);
    }

    //通过id查询管理员信息
    public List queryMangerInfoById(int Id){
        List result = dao.queryByParam(managerClassName,managerParam0,Id);
        return result;
    }

    //通过id查询图书
    public List queryBookById(int Id){
        List result = dao.queryByParam(bookClassName,bookParam0,Id);
        return  result;
    }

    //通过bookId查询个人图书表
    public List queryPersonalBook(int Id){
        List result = dao.queryByParam(personalBookClassName,personalBookParam2,Id);
        return  result;
    }

    //通过personalBookId查询借阅表
    public List queryBorrowHistoryItem(int Id){
        List result = dao.queryByParam(borrowHistoryItemClassName,personalBookParam1,Id);
        return  result;
    }

    //修改图书
    public boolean updateBook(Object object){
        return dao.updateByObject(object);
    }

    //添加图书
    public boolean addBook(Object object){
        return dao.updateByObject(object);
    }

    //通过BookId删除图书表
    public boolean deleteBook(int id){
        return dao.deleteByHql(bookClassName,bookParam0,id);
    }

    //根据bookId删除个人图书表
    public boolean deletePersonalBook(int id){
        return dao.deleteByHql(personalBookClassName,personalBookParam1,id);
    }

    //通过personalBookId删除借书记录表
    public boolean deleteBorrowHistoryItem(int id){
        return dao.deleteByHql(borrowHistoryItemClassName,personalBookParam1,id);
    }

    //通过personalBookId删除收藏车
    public boolean deleteCollectCarItem(int id){
        return dao.deleteByHql(collectCarItemClassName,personalBookParam1,id);
    }

    //通过personalBookId删除书籍评论
    public boolean deleteCommentItem(int id){
        return dao.deleteByHql(commentItemClassName,personalBookParam1,id);
    }

    //查询管理员信息()
    public List queryManager(List list,int pageNo){
        switch (list.size()){
            case 2:
                if(list.get(1).toString().equals("0")||list.get(1).toString().equals("1")){
                    int permission;
                    permission = Integer.parseInt(list.get(1).toString());
                    allManager = dao.queryByParam(managerClassName,list.get(0).toString(),permission);
                    break;
                }else{
                    allManager = dao.queryByParam(managerClassName,list.get(0).toString(),list.get(1));
                    break;
                }
            case 4:
                if(list.get(3).toString().equals("0")||list.get(3).toString().equals("1")){
                    int permission;
                    permission = Integer.parseInt(list.get(1).toString());
                    allManager = dao.queryByParam(managerClassName,list.get(0).toString(),list.get(1).toString(),list.get(2).toString(),permission);
                    break;
                }

            default :
                    allManager = null;
                    break;
        }
        Map m = ActionContext.getContext().getSession();
        //查询不到数据
        if(allManager==null||allManager.size()==0){
            result = null;
            System.out.println("result==null");
        }else{
            //求出总页数
            if(allManager.size()%pageSize==0){
                totalPage=allManager.size()/pageSize;
            }else{
                totalPage=allManager.size()/pageSize+1;
            }
            m.put("managerInfoTotalPage",totalPage);
            //限制当前页数
            if(pageNo<=0){
                pageNo=1;
            }else if(pageNo>totalPage){
                pageNo=totalPage;
            }
            //最后一页的大小
            lastSize =pageSize-(totalPage*pageSize-allManager.size());

            //要显示的条数
            if(totalPage == pageNo){
                showItems = lastSize;
            }else {
                showItems = 5;
            }

            //第一条数据的位置
            firstNo = pageNo*pageSize-5;

            for(int i = firstNo; i < showItems+firstNo ; i++ ){
                result.add(allManager.get(i));
            }
            m.put("managerInfoCurrentPage",pageNo);
        }
        return result;

    }

    //查询图书
    public List queryBook(List list,int pageNo){

        switch(list.size()){
            case 2:
                allBooks = dao.queryByParam(bookClassName,list.get(0).toString(),list.get(1));
                break;
            case 4:
                allBooks = dao.queryByParam(bookClassName,list.get(0).toString(),list.get(1),list.get(2).toString(),list.get(3));
                break;
            case 6:
                allBooks = dao.queryByParam(bookClassName,list.get(0).toString(),list.get(1),list.get(2).toString(),list.get(3),list.get(4).toString(),list.get(5));
                break;
            case 8:
                allBooks = dao.queryByParam(bookClassName,list.get(0).toString(),list.get(1),list.get(2).toString(),list.get(3),list.get(4).toString(),list.get(5),list.get(6).toString(),list.get(7));
                break;
            case 10:
                allBooks = dao.queryByParam(bookClassName,list.get(0).toString(),list.get(1),list.get(2).toString(),list.get(3),list.get(4).toString(),list.get(5),list.get(6).toString(),list.get(7),list.get(8).toString(),list.get(9));
                break;
            case 0:
                allBooks = null;
                break;
            case 1: //按bookId查询
                if(list.get(0).toString().trim().equals("all")){
                    allBooks = dao.queryByParam(bookClassName);
                }else{
                    int bid;
                    bid = Integer.parseInt(list.get(0).toString());
                    allBooks = dao.queryByParam(bookClassName,bookParam0,bid);
                }

                break;
            default :
                allBooks = null;
                System.out.println("其他");

        }

        Map m = ActionContext.getContext().getSession();
        //查询不到数据
        if(allBooks==null||allBooks.size()==0){
            result = null;
        }else{
            //求出总页数
            if(allBooks.size()%pageSize==0){
                totalPage=allBooks.size()/pageSize;
            }else{
                totalPage=allBooks.size()/pageSize+1;
            }
            m.put("managerTotalPage",totalPage);
            //限制当前页数
            if(pageNo<=0){
                pageNo=1;
            }else if(pageNo>totalPage){
                pageNo=totalPage;
            }
            //最后一页的大小
            lastSize =pageSize-(totalPage*pageSize-allBooks.size());

            //要显示的条数
            if(totalPage == pageNo){
                showItems = lastSize;
            }else {
                showItems = 5;
            }

            //第一条数据的位置
            firstNo = pageNo*pageSize-5;

            for(int i = firstNo; i < showItems+firstNo ; i++ ){
                result.add(allBooks.get(i));
            }
            m.put("managerCurrentPage",pageNo);
        }
        return result;
    }

    //操作员更新PersonalBook
    public boolean updatePersonalBook(Object object){
        return dao.updateByObject(object);
    }

    //操作员更新借阅记录表
    public boolean updateBorrowHistoryItem(Object object){
        return dao.updateByObject(object);
    }

    //通过shareCode查询PersonalBook
    public List queryPersonalBookByShareCode(int id){
        List result = dao.queryByParam(personalBookClassName,personalBookParam6,id);
        return result;
    }

    //通过borrowCode查询BorrowHistoryItem
    public List queryBorrowHistoryItemByBorrowCode(int id){
        List result = dao.queryByParam(borrowHistoryItemClassName,borrowHistoryItemParam7,id);
        return result;
    }
    //通过personalBookId查询PersonalBook表
    public List queryPersonalBookByPersonalBookId(int id){
        List result = dao.queryByParam(personalBookClassName,personalBookParam1,id);
        return result;
    }

    //操作员同时更新personalBook和borrowHistoryItem
    public boolean updatePersonalBookAndBorrowHistoryItem(Object object1,Object object2){
        return dao.updateByTwoObject(object1,object2);
    }

    //通过returnCode查询BorrowHistoryItem
    public List queryBorrowHistoryItemByReturnCode(String returnCode){
        List result = dao.queryByParam(borrowHistoryItemClassName,getBorrowHistoryItemParam8,returnCode);
        return result;
    }

    //通过getBookCode查询PersonalBook
    public List queryPersonalBookByGetBookCode(String getBookCode){
        List result = dao.queryByParam(personalBookClassName,personalBookParam8,getBookCode);
        return result;
    }

    //通过userId查询UserInfo
    public List queryUserInfoByUserId(int id){
        List result = dao.queryByParam(userClassName,userParam0,id);
        return result;
    }

}
