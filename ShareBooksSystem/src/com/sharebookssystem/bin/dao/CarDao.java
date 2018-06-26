package com.sharebookssystem.bin.dao;

import com.sharebookssystem.model.CollectCarItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collection;

public class CarDao {
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public CarDao(){

    }

    public int addInCar(CollectCarItem collectCarItem){
        int num=0;
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            num=Integer.parseInt(session.save(collectCarItem).toString());
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

    //删除借阅车图书
    public int deleteBookFromCar(int personalBookId,int userId){
        int num=0;
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            String hql="delete from CollectCarItem where personalBookId="+personalBookId+" and userId ="+userId;
            Query queryupdate=session.createQuery(hql);
            num=queryupdate.executeUpdate();
//            transaction.commit();

//            num=Integer.parseInt(session.delete(personalBookId).toString());
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


    public Collection checkMyBorrowCar(int userId){
        Session session=null;
        Transaction transaction=null;
        try {
            session=sessionFactory.openSession();
            String queryString="from Book bk,PersonalBook pk,CollectCarItem cm where bk.bookId=pk.book " +
                    "and cm.personalBook=pk.personalBookId and cm.user= "+userId;
            Query query=session.createQuery(queryString);
            //设置获取的数据数量
//            query.setFirstResult()
            System.out.print("adsfasdfdas");
            Collection collectItem = query.list();//获取结果
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
            return collectItem;//返回Collection对象
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
    public Collection checkMyBorrowCarByPage(int userId,int pageNo,int pageSize){
        Session session=null;
        Transaction transaction=null;
        try {
            session=sessionFactory.openSession();
            String queryString="from Book bk,PersonalBook pk,CollectCarItem cm where bk.bookId=pk.book " +
                    "and cm.personalBook=pk.personalBookId and cm.user= "+userId;
            Query query=session.createQuery(queryString);
            //设置获取的数据数量
            query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
            //这一页显示的记录个数
            query.setMaxResults(pageSize);
//            query.setFirstResult()
            System.out.print("adsfasdfdas");
            Collection collectItem = query.list();//获取结果
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
            return collectItem;//返回Collection对象
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
}
