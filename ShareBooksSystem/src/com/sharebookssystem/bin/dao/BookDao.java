package com.sharebookssystem.bin.dao;

import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.BorrowHistoryItem;
import com.sharebookssystem.model.PersonalBook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public class BookDao {
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Collection checkBook(String check_data){
        Session session=null;
        Transaction transaction=null;
        try {
            session=sessionFactory.openSession();
            String queryString="from Book bk,PersonalBook pk where bk.bookId=pk.book and bk.bookName " +
                    "like '%"+check_data+
                    "%' or bk.bookAuthor like '%"+check_data+"%'";
            Query query=session.createQuery(queryString);
            //设置获取的数据数量
//            query.setFirstResult()
            System.out.print("adsfasdfdas");
            Collection books = query.list();//获取结果
            System.out.print("adsfasdfdas");

//            System.out.println(books);
//            for (int i=0;i<books.size();i++){
//                Object[] o = (Object[])books.get(i);
//
//                System.out.print(o[0] + ",");
//                System.out.print(o[1] + ",");
//                System.out.print(o[0].getClass() + ",");
//                System.out.print(o[1] + ",");
////                System.out.print(o[2] + ",");
////                System.out.println(o[3]);
//            }
            return books;//返回Collection对象
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    public int addBook(Book book){
        int num=0;
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            num=Integer.parseInt(session.save(book).toString());
            System.out.println("show hql");
            transaction.commit(); //写入数据库，
        }catch (Exception e) {
            e.printStackTrace();
            num=0;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
        return num;
    }

    public int addMyBook(PersonalBook book){
        int num=0;
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            num=Integer.parseInt(session.save(book).toString());
            System.out.println("show hql");
            transaction.commit(); //写入数据库，
        }catch (Exception e) {
            e.printStackTrace();
            num=0;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
        return num;
    }

    public int borrowBook(BorrowHistoryItem borrowHistoryItem){
        int num=0;
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            num=Integer.parseInt(session.save(borrowHistoryItem).toString());
            System.out.println("show hql");
            transaction.commit(); //写入数据库，
        }catch (Exception e) {
            e.printStackTrace();
            num=0;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
        return num;
    }
}
