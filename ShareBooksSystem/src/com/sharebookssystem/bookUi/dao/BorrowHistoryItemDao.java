package com.sharebookssystem.bookUi.dao;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.model.BorrowHistoryItem;
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

}
