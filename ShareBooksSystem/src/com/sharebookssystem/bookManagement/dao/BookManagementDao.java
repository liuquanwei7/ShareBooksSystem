package com.sharebookssystem.bookManagement.dao;


import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.Manager;

import java.util.List;

public interface BookManagementDao {

    //通过Id查询实例
    public Object queryById(Object object,int id);

    //删除
    public boolean deleteByObject(Object object);

    //通过hql删除
    public boolean deleteByHql(String className,String param1,int value1);

    //通过Object添加或更新
    public boolean updateByObject(Object object);

    //查询全部
    public List queryByParam(String className);

    //一个参数查询
    public List queryByParam(String className,String param1,Object value1);

    //两个参数查询
    public List queryByParam(String className,String param1,Object value1,String param2,Object value2);

    //三个参数查询
    public List queryByParam(String className,String param1,Object value1,String param2,Object value2,String param3,Object value3);

    //四个参数查询
    public List queryByParam(String className,String param1,Object value1,String param2,Object value2,String param3,Object value3,String param4,Object value4);

    //五个参数查询
    public List queryByParam(String className,String param1,Object value1,String param2,Object value2,String param3,Object value3,String param4,Object value4,String param5,Object value5);

}
