package com.sharebookssystem.bookManagement.service.impl;

import com.sharebookssystem.bookManagement.dao.hibernate.BookManagementDaoImpl;
import com.sharebookssystem.bookManagement.service.BookManagementService;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.Manager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 实现类
 * 2018/6/5
 */


public class BookManagementServiceImpl implements BookManagementService {
    public static final String bookClassName = "Book";
    public static final String bookParam0 = "bookId";
    public static final String managerClassName = "Manager";
    public static final String managerParam1 = "managerAccount";
    public static final String managerParam2 = "managerPassword";

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

    public boolean isExistManager(String managerAccount,String managerPassword){
        System.out.println("1="+managerAccount+"2="+managerPassword);
        List<Object> result = dao.queryByParam(managerClassName,managerParam1,managerAccount,managerParam2,managerPassword);
        if(result.size()>0){
            return true;
        }else {
            return false;
        }
    }

    //通过id查询图书
    public List queryBookById(String Id){
        List result = dao.queryByParam(bookClassName,bookParam0,Id);
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

    //删除图书
    public boolean deleteBook(Object object,int id){
        return dao.deleteById(object,id);
    }

    //确认从A收到A的书
    public boolean confirmFromA(Object object,int id){
        return dao.updateByObject(object);
    }

    //确认借出A的书
    public boolean confirmToB(Object object,int id){
        return dao.updateByObject(object);
    }

    //确认从B收到A的书
    public boolean confirmFromB(Object object,int id){
        return dao.updateByObject(object);
    }

    //确认归还A的书
    public boolean confirmToA(Object object,int id){
        return dao.updateByObject(object);
    }

    //通过一个参数查询图书
    public List queryBook(String param1,String value1){
        List result = dao.queryByParam(bookClassName,param1,value1);
        return result;
    }

    //通过两个参数查询图书
    public List queryBook(String param1,String value1,String param2,String value2){
        List result = dao.queryByParam(bookClassName,param1,value1,param2,value2);
        return result;
    }

    //通过三个参数查询图书
    public List queryBook(String param1,String value1,String param2,String value2,String param3,String value3){
        List result = dao.queryByParam(bookClassName,param1,value1,param2,value2,param3,value3);
        return result;
    }

    //通过四个参数查询图书
    public List queryBook(String param1,String value1,String param2,String value2,String param3,String value3,String param4,String value4){
        List result = dao.queryByParam(bookClassName,param1,value1,param2,value2,param3,value3,param4,value4);
        return result;
    }

    //通过五个参数查询图书
    public List queryBook(String param1,String value1,String param2,String value2,String param3,String value3,String param4,String value4,String param5,String value5){
        List result = dao.queryByParam(bookClassName,param1,value1,param2,value2,param3,value3,param4,value4,param5,value5);
        return result;
    }

}
