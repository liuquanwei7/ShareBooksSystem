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

    public List<BorrowHistoryItem> queryPersonalId(BorrowHistoryItem bd, int userid){
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
            if(list.size()>0){
                list=list;

                int[] a=new int[list.size()];
                int[] b=new int[list.size()];
                int mounts=0;
                for(int i=0;i<list.size();i++){

                    bd=list.get(i);

                    if(bd.getBorrowStatus().equals("未还")) {
                        a[mounts] = bd.getPersonalBook().getPersonalBookId();
                        b[mounts]=bd.getBorrowHistoryItemId();
                        System.out.println("未还："+b[mounts]);
                        mounts++;
                    }
                }
                if(mounts==0){
                    list=null;
                    return list;
                }
                ss.put("a",a);
                ss.put("mounts",mounts);
                System.out.println("数量"+mounts);
                String hqlsss="";
                for(int j=0;j<mounts;j++){
                    hqlsss=hqlsss+b[j];
                    System.out.println("测试hqlss"+hqlsss);
                    if((j+1)<mounts){
                       hqlsss=hqlsss +",";

                    }
                    else{
                        break;
                    }
                }
                System.out.println("测试hqlss"+hqlsss);
                String queryStrings="from BorrowHistoryItem where BorrowHistoryItemId in("+hqlsss+")";
                //创建查询
                Query queryObjects=session.createQuery(queryStrings);
                List<BorrowHistoryItem> lists=queryObjects.list();
                if(lists.size()>0){
                    lists=lists;
                    return lists;
                }else{
                    lists=null;
                    return lists;
                }

            }
            else{
                list=null;
                return list;
            }

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
            if(list.size()>0){

                int[] a=new int[list.size()];
                int mounts=0;
                int x=0;
                int co=0;
                int pancou=0;
                for(x=0,co=0;co<list.size();co++){
                    pancou=0;
                    for(int m=0;m<x;m++){
                        if(a[m]==list.get(co).getPersonalBook().getPersonalBookId()){
                            pancou=1;
                            System.out.println("运行测试1");
                            break;
                        }
                    }
                    if(pancou==0){
                        a[x]=list.get(co).getPersonalBook().getPersonalBookId();
                        //防止取多次
                        x++;
                    }
                }
                mounts=x;
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

                if(listPersons.size()>0){
                    listPersons=listPersons;
                    int []booksid=new int[3];
                    int bookmin=0;
                    for (int i=0;i<listPersons.size();i++){
                        if(i<3){
                            booksid[i]=listPersons.get(i).getBook().getBookId();
                        }
                        else{
                            for(int j=0;j<3;j++){
                                if(listPersons.get(j).getNumberOfTimes()<listPersons.get(bookmin).getNumberOfTimes()){
                                    bookmin=j;
                                    break;
                                }
                            }
                            for (int c=0;c<3;c++){


                                if(listPersons.get(i).getNumberOfTimes()>listPersons.get(c).getNumberOfTimes()){
                                    booksid[bookmin]=listPersons.get(i).getBook().getBookId();
                                    break;
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
                    if(listBooks.size()>0){
                        listBooks=listBooks;
                        ss.put("books",listBooks);

                        System.out.println("分界线");

                        String hqlnew="";
                        for(int i=0;i<3;i++){
                            hqlnew=hqlnew+booksid[i];
                            if((i+1)!=3){
                                hqlnew=hqlnew+",";
                            }
                        }
                        String queryStringperBooksnew="from PersonalBook where BookId in("+hqlnew+")";
                        System.out.println("重新person"+queryStringperBooksnew);
                        //创建查询
                        Query queryObjectBooksNeW=session.createQuery(queryStringperBooksnew);


                        List<PersonalBook> listPersonsnew=queryObjectBooksNeW.list();
                        if(listPersonsnew.size()>0){
                            ss.put("personalbooks",listPersonsnew);
                            return true;
                        }else{
                            listPersonsnew=null;
                        }

                    }else {
                        listBooks=null;
                    }
                }else {
                    listPersons=null;
                }
            }
            else{
                list=null;

            }
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
