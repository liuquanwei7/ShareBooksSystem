package com.sharebookssystem.bin.dao;

import com.sharebookssystem.model.Book;
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
}
