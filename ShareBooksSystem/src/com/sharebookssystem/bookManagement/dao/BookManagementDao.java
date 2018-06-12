package com.sharebookssystem.bookManagement.dao;


import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.Manager;

import java.util.List;

public interface BookManagementDao {

    //通过Id查询实例
    public Object queryById(Object object,int id);

    //通过Id删除
    public boolean deleteById(Object object,int id);

    //通过Object添加或更新
    public boolean updateByObject(Object object);

    //一个参数查询
    public List queryByParam(String className,String param1,String value1);

    //两个参数查询
    public List queryByParam(String className,String param1,String value1,String param2,String value2);

    //三个参数查询
    public List queryByParam(String className,String param1,String value1,String param2,String value2,String param3,String value3);

    //四个参数查询
    public List queryByParam(String className,String param1,String value1,String param2,String value2,String param3,String value3,String param4,String value4);

    //五个参数查询
    public List queryByParam(String className,String param1,String value1,String param2,String value2,String param3,String value3,String param4,String value4,String param5,String value5);

}
