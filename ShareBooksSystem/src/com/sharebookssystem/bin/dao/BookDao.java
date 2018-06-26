package com.sharebookssystem.bin.dao;

import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.BorrowHistoryItem;
import com.sharebookssystem.model.PersonalBook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.ResultSet;
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


    //查询个人图书
    public List<PersonalBook> checkPersonalBookin(int check_have ){
        Session session=null;
        Transaction transaction=null;
        try {
            session=sessionFactory.openSession();
//            String queryString="from PersonalBook pk where pk.bookId " +
//                    "like '%"+check_have;
            String queryString="from PersonalBook pk where pk.book =" + check_have;
            Query query=session.createQuery(queryString);
            //设置获取的数据数量
//            query.setFirstResult()
            System.out.print("adsfasdfdas");
            List res=query.list();
            List<PersonalBook> book=res; //获取结果
            System.out.print("adsfasdfdas");
            if(res.size()>0){
                book=res;
            }else{
                book=null;
            }
//            List<PersonalBook> book= query.list();//获取结果
            System.out.print("adsfasdfdas");


            return book;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    //查询图书
    public List<Book> checkBookin(String check_have){
        Session session=null;
        Transaction transaction=null;
        try {
            session=sessionFactory.openSession();
            String queryString="from Book bk where bk.bookName " +
                    "like '%"+check_have+
                    "%'";
            Query query=session.createQuery(queryString);
            //设置获取的数据数量
//            query.setFirstResult()
            System.out.print("adsfasdfdas");
            List res=query.list();
            List<Book> book=res; //获取结果
            System.out.print("adsfasdfdas");
            if(res.size()>0){
                book=res;
            }else{
                book=null;
            }
            System.out.println(book);

            return book;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
//查询图书操作
    public Collection checkBook(String check_data){
        Session session=null;
        Transaction transaction=null;
        try {
            session=sessionFactory.openSession();
            String queryString="from Book bk,PersonalBook pk where bk.bookId=pk.book and ( bk.bookName " +
                    "like '%"+check_data+
                    "%' or bk.bookAuthor like '%"+check_data+"%')";
            Query query=session.createQuery(queryString);
            //设置获取的数据数量
//            query.setFirstResult()
            System.out.print("adsfasdfdas");
            List res=query.list();
            Collection books=res; //获取结果
            System.out.print("adsfasdfdas");
            if(res.size()>0){
                books=res;
            }else{
                books=null;
            }
//            Collection books = query.list();//获取结果
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
    }public Collection checkBookByPersonalId(int PersonalId){
        Session session=null;
        Transaction transaction=null;
        try {
            session=sessionFactory.openSession();
            String queryString="from Book bk,PersonalBook pk where bk.bookId=pk.book and pk.personalBookId="+PersonalId;
            Query query=session.createQuery(queryString);
            //设置获取的数据数量
//            query.setFirstResult()
            System.out.print("adsfasdfdas");
            List res=query.list();
            Collection books=res; //获取结果
            System.out.print("adsfasdfdas");
            if(res.size()>0){
                books=res;
            }else{
                books=null;
            }
//            Collection books = query.list();//获取结果
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
    public Collection checkBookByPage(String check_data,int pageNo,int pageSize){
        Session session=null;
        Transaction transaction=null;
        try {
            session=sessionFactory.openSession();
            String queryString="from Book bk,PersonalBook pk where bk.bookId=pk.book and ( bk.bookName " +
                    "like '%"+check_data+
                    "%' or bk.bookAuthor like '%"+check_data+"%')";
            Query query=session.createQuery(queryString);
            //设置获取的数据数量
            query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
            //这一页显示的记录个数
            query.setMaxResults(pageSize);
//            query.setFirstResult()
            System.out.print("adsfasdfdas");
            List res=query.list();
            Collection books=res; //获取结果
            System.out.print("adsfasdfdas");
            if(res.size()>0){
                books=res;
            }else{
                books=null;
            }
//            Collection books = query.list();//获取结果
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
    // 查看个人图书
    public Collection checkMyBook(int userId){
        Session session=null;
        Transaction transaction=null;
        try {
            session=sessionFactory.openSession();
//            String queryString="from Book bk,PersonalBook pk where bk.bookId=pk.book and ( bk.bookName " +
//                    "like '%"+check_data+
//                    "%' or bk.bookAuthor like '%"+check_data+"%')";
            String queryString="from Book bk,PersonalBook pk where bk.bookId=pk.book and pk.user="+userId;
            Query query=session.createQuery(queryString);
            //设置获取的数据数量
//            query.setFirstResult()
            System.out.print("adsfasdfdas");
            List res=query.list();
            Collection books=res; //获取结果
            System.out.print("adsfasdfdas");
            if(res.size()>0){
                books=res;
            }else{
                books=null;
            }
//            Collection books = query.list();//获取结果
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
    //分页查看图书
    public Collection checkMyBookByPage(int userId,int pageNo,int pageSize){
        Session session=null;
        Transaction transaction=null;
        try {
            System.out.println(pageNo+"this is ");
            System.out.println(pageSize+"this is aa");
            session=sessionFactory.openSession();
//            String queryString="from Book bk,PersonalBook pk where bk.bookId=pk.book and ( bk.bookName " +
//                    "like '%"+check_data+
//                    "%' or bk.bookAuthor like '%"+check_data+"%')";
            String queryString="from Book bk,PersonalBook pk where bk.bookId=pk.book and pk.user="+userId;
            Query query=session.createQuery(queryString);
            query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
            //这一页显示的记录个数
            query.setMaxResults(pageSize);
            //设置获取的数据数量
//            query.setFirstResult()
            System.out.print("adsfasdfdas");
            List res=query.list();
            Collection books=res; //获取结果
            System.out.print("adsfasdfdas");
            if(res.size()>0){
                books=res;
            }else{
                books=null;
            }
//            Collection books = query.list();//获取结果
            System.out.print("adsfasdfdas");
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

    public boolean getMyBook(PersonalBook personalBook){
        int num=0;
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.update(personalBook);
            System.out.println("show hql");
            transaction.commit(); //写入数据库，
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{//关闭session
            session.close();
//            HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
        }
//        return num;
    }

    //获取借书者邮箱
    public Collection checkEmail(int personalBookId){
        Session session=null;
        Transaction transaction=null;
        try {
            session=sessionFactory.openSession();
//            String queryString="from Book bk,PersonalBook pk where bk.bookId=pk.book and ( bk.bookName " +
//                    "like '%"+check_data+
//                    "%' or bk.bookAuthor like '%"+check_data+"%')";
            String queryString="from PersonalBook pk,BorrowHistoryItem bh,User ur where pk.personalBookId=bh.personalBook " +
                    "and bh.borrower=ur.userId and pk.personalBookId ="+personalBookId+" and bh.borrowStatus!='已借出'";
            Query query=session.createQuery(queryString);
            //设置获取的数据数量
//            query.setFirstResult()
//            System.out.print("adsfasdfdas");
            List res=query.list();
            Collection books=res; //获取结果
            System.out.print(books);
            if(res.size()>0){
                books=res;
            }else{
                books=null;
            }
//            Collection books = query.list();//获取结果
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
}
