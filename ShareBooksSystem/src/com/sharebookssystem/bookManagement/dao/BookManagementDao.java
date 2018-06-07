package com.sharebookssystem.bookManagement.dao;


import com.sharebookssystem.model.Manager;

public interface BookManagementDao {

    //验证登陆
    public boolean queryManager(Manager manager);

}
