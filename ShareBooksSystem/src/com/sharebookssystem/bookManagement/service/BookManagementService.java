package com.sharebookssystem.bookManagement.service;

import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.Manager;

import java.util.List;

public interface BookManagementService {

    //判断管理员账户是否存在

    public boolean isExistManager(String managerAccount,String managerPassword);

    //通过id查询图书
    public List queryBookById(String Id);

    //修改图书
    public boolean updateBook(Object object);

    //添加图书
    public boolean addBook(Object object);

    //删除图书
    public boolean deleteBook(Object object,int id);

    //确认从A收到A的书
    public boolean confirmFromA(Object object,int id);

    //确认借出A的书
    public boolean confirmToB(Object object,int id);

    //确认从B收到A的书
    public boolean confirmFromB(Object object,int id);

    //确认归还A的书
    public boolean confirmToA(Object object,int id);

    //通过一个参数查询图书
    public List queryBook(String param1,String value1);

    //通过两个参数查询图书
    public List queryBook(String param1,String value1,String param2,String value2);

    //通过三个参数查询图书
    public List queryBook(String param1,String value1,String param2,String value2,String param3,String value3);

    //通过四个参数查询图书
    public List queryBook(String param1,String value1,String param2,String value2,String param3,String value3,String param4,String value4);

    //通过五个参数查询图书
    public List queryBook(String param1,String value1,String param2,String value2,String param3,String value3,String param4,String value4,String param5,String value5);
}
