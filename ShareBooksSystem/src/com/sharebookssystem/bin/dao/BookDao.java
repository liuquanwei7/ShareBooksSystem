package com.sharebookssystem.bin.dao;

import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.PersonalBook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
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

    public List<Book> checkBook(String check_data){
        Session session=null;
        Transaction transaction=null;
        try {
            session=sessionFactory.openSession();
            String queryString="from Book where bookName like '%"+check_data+
                    "%' or bookAuthor like '%"+check_data+"%'";
            Query query=session.createQuery(queryString);
            //设置获取的数据数量
//            query.setFirstResult()
            List<Book> books = query.list();


            return books;
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
}
