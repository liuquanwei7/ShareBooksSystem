package com.sharebookssystem.bookUi.dao;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.BorrowHistoryItem;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Map;

import static sun.misc.MessageUtils.where;

public class BorrowHistoryItemDao {
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public BorrowHistoryItem queryPersonalId(BorrowHistoryItem bd, int userid){
        Session session = null;
        try{
            //调用HibernateSessionFactory获得session
            session = sessionFactory.openSession();
            String queryString="from BorrowHistoryItem where borrowerID=?";
            //创建查询
            Query queryObject=session.createQuery(queryString);
            queryObject.setParameter(0, userid);

            ActionContext ac=ActionContext.getContext();
            //	Map map=ActionContext.getContext().getSession();
            //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
            //拿到表示request对象 的map
            Map<String, Object> request=ac.getContextMap();
            Map<String, Object> ss=ac.getSession();

            List<BorrowHistoryItem> list=queryObject.list();

            int[] a=new int[list.size()];
            int mounts=0;
            for(int i=0;i<list.size();i++){

                bd=list.get(i);

                if(bd.getBorrowStatus().equals("未还")) {
                    a[i] = bd.getPersonalBook().getPersonalBookId();
                    System.out.println(a[i]);
                    mounts++;
                }
            }
            ss.put("a",a);
            ss.put("mounts",mounts);
            System.out.println("数量"+mounts);
            return bd;

        }catch(Exception ex){
            System.out.println("888888888888444444444444444444");

            ex.printStackTrace();
            return null;
        }finally{
            //关闭session
            session.close();
        }
    }

    public boolean queryPages(){
        Session session = null;
        try{
            //调用HibernateSessionFactory获得session
            session = sessionFactory.openSession();
            String queryString="from BorrowHistoryItem";
            //创建查询
            Query queryObject=session.createQuery(queryString);

            ActionContext ac=ActionContext.getContext();
            //	Map map=ActionContext.getContext().getSession();
            //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
            //拿到表示request对象 的map
            Map<String, Object> request=ac.getContextMap();
            Map<String, Object> ss=ac.getSession();

            List<BorrowHistoryItem> list=queryObject.list();

            int[] a=new int[list.size()];
            int mounts=0;

            for(int i=0;i<list.size();i++){
                a[i]=list.get(i).getPersonalBook().getPersonalBookId();
            }
            mounts=list.size();


            String hql="";
            System.out.println("length(personalbook)"+mounts);
            for(int i=0;i<mounts;i++){
                hql=hql+a[i];
                if((i+1)!=mounts){
                    hql=hql+",";
                }
            }
            String queryStrings="from PersonalBook where PersonalBookId in("+hql+")";
            System.out.println(queryStrings);
            //创建查询
            Query queryObjects=session.createQuery(queryStrings);


            List<PersonalBook> listPersons=queryObjects.list();
            int []booksid=new int[3];

            for (int i=0;i<listPersons.size();i++){
                if(i<3){
                    booksid[i]=listPersons.get(i).getBook().getBookId();
                }
                else{
                    for (int j=0;j<3;j++){
                        if(listPersons.get(i).getNumberOfTimes()>listPersons.get(j).getNumberOfTimes()){
                            booksid[j]=listPersons.get(i).getBook().getBookId();
                        }
                    }
                }

            }

            String hqls="";
//            System.out.println("length(personalbook)"+mounts);
            for(int i=0;i<3;i++){
                hqls=hqls+booksid[i];
                if((i+1)!=3){
                    hqls=hqls+",";
                }
            }
            String queryStringBooks="from Book where BookId in("+hqls+")";
            System.out.println(queryStringBooks);
            //创建查询
            Query queryObjectBooks=session.createQuery(queryStringBooks);


            List<Book> listBooks=queryObjectBooks.list();

            ss.put("personalbooks",listPersons);
            ss.put("books",listBooks);

        }catch(Exception ex){
            System.out.println("888888888888444444444444444444");

            ex.printStackTrace();
            return false;
        }finally{
            //关闭session
            session.close();
        }
        return true;
    }

}
