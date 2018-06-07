package com.sharebookssystem.bookManagement.service;

import com.sharebookssystem.model.Manager;

public interface BookManagementService {

    //判断管理员账户是否存在

    public boolean isExistManager(Manager manager);
}
