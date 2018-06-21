package com.sharebookssystem.bookUi.dao;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.model.BorrowHistoryItem;
import com.sharebookssystem.model.PersonalBook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class PersonalBookDao {
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public PersonalBook queryBookId(PersonalBook  pb){
        Session session = null;
        try{
            //调用HibernateSessionFactory获得session
             ActionContext ac=ActionContext.getContext();
                        //	Map map=ActionContext.getContext().getSession();
                        //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
                        //拿到表示request对象 的map
                        Map<String, Object> request=ac.getContextMap();
                        Map<String, Object> ss=ac.getSession();
                        int length=(Integer) ss.get("mounts");
                        String hql="";
                        int[] a=new int[length];
                        a=(int[]) ss.get("a");
                        System.out.println("length"+length);
                        for(int i=0;i<length;i++){
                            hql=hql+a[i];
                            if((i+1)!=length){
                                hql=hql+",";
                            }
                        }
                        System.out.println(hql);
            System.out.println("检查hql");


            session = sessionFactory.openSession();
            String queryString="from PersonalBook where PersonalBookId in("+hql+")";
            //创建查询
            Query queryObject=session.createQuery(queryString);


            List<PersonalBook> list=queryObject.list();
            int[] pdarray=new int[list.size()];
            for(int i=0;i<list.size();i++){

                pb=list.get(i);

                pdarray[i] = pb.getBook().getBookId();
                System.out.println(pdarray[i]);

            }

            ss.put("pdarray",pdarray);
            return pb;

        }catch(Exception ex){
            System.out.println("888888888888444444444444444444");

            ex.printStackTrace();
            return null;
        }finally{
            //关闭session
            session.close();
        }
    }


}
