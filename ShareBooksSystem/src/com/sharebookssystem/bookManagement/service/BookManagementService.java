package com.sharebookssystem.bookManagement.service;

import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.Manager;

import java.util.List;

public interface BookManagementService {

    //判断管理员账户是否存在
    public boolean isExistManager(String managerAccount,String managerPassword,int managerPermission);

    //注册管理员账户
    public boolean registerManager(Object object);

    //判断注册管理员账号是否重复
    public boolean isSameAccount(String managerAccount);

    //查询管理员信息()
    public List queryManager(List list,int pageNo);

    //修改管理员信息
    public boolean updateManagerInfo(Object object);

    //更新管理员密码
    public boolean updateManagerPassword(Object object);

    //删除管理员信息
    public boolean deleteManagerIno(int id);

    //通过id查询图书
    public List queryBookById(int Id);

    //通过id查询管理员信息
    public List queryMangerInfoById(int Id);

    //通过bookId查询个人图书表
    public List queryPersonalBook(int Id);

    //通过personalBookId查询借阅表
    public List queryBorrowHistoryItem(int Id);

    //修改图书
    public boolean updateBook(Object object);

    //添加图书
    public boolean addBook(Object object);


    //通过BookId删除图书表
    public boolean deleteBook(int id);

    //根据bookId删除个人图书表
    public boolean deletePersonalBook(int id);

    //通过personalBookId删除借书记录表
    public boolean deleteBorrowHistotyItem(int id);

    //通过personalBookId删除收藏车
    public boolean deleteCollectCarItem(int id);

    //通过personalBookId删除书籍评论
    public boolean deleteCommentItem(int id);

    //确认从A收到A的书
    public boolean confirmFromA(Object object,int id);

    //确认借出A的书
    public boolean confirmToB(Object object,int id);

    //确认从B收到A的书
    public boolean confirmFromB(Object object,int id);

    //确认归还A的书
    public boolean confirmToA(Object object,int id);

    //查询图书
    public List queryBook(List list,int pageNo);
}
