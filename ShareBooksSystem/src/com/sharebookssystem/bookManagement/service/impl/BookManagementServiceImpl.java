package com.sharebookssystem.bookManagement.service.impl;

import com.sharebookssystem.bookManagement.dao.hibernate.BookManagementDaoImpl;
import com.sharebookssystem.bookManagement.service.BookManagementService;
import com.sharebookssystem.model.Manager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 实现类
 * 2018/6/5
 */


public class BookManagementServiceImpl implements BookManagementService {

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

    public boolean isExistManager(Manager manager){
        return dao.queryManager(manager);
    }
}
