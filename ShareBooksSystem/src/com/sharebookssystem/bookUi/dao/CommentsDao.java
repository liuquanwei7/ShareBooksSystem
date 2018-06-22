package com.sharebookssystem.bookUi.dao;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.CommentItem;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;
import org.hibernate.*;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;

public class CommentsDao {
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<CommentItem> queryComments(CommentItem com){
        Session session = null;
        try{
            //调用HibernateSessionFactory获得session
            ActionContext ac=ActionContext.getContext();
            //	Map map=ActionContext.getContext().getSession();
            //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
            //拿到表示request对象 的map
            Map<String, Object> request=ac.getContextMap();
            Map<String, Object> ss=ac.getSession();

            User user=(User) ss.get("user");
            int userid=user.getUserId();
            int personalbookid=(int)ss.get("myPersonalBookid");


            int length=0;
            String hql="";
            int pageNo;


            System.out.println(length);

            session = sessionFactory.openSession();
            String queryString="from CommentItem where personalBookId =? ";
            //创建查询

            Query queryObject=session.createQuery(queryString);
            queryObject.setParameter(0, personalbookid);


            List<CommentItem> list=queryObject.list();
            int pagelast=list.size()%5;//最后一页多少数据
            int pageSize=list.size()/5;//多少页
            int pages=0;
            if(pagelast!=0){
                pages=pageSize+1;
            }
            else {
                pages=pageSize;
            }
            //存入总页数
            ss.put("pages",pages);

            System.out.println("userId:"+list.get(0).getReview());

            System.out.println("userId:"+list.get(0).getReviewer().getUserId());
            //存入评论对象
            ss.put("allComments",list);
            return list;
        }catch(Exception ex){
            System.out.println("888888888888444444444444444444");

            ex.printStackTrace();
            return null;
        }finally{
            //关闭session
            session.close();
        }
    }



    public int insertComments(CommentItem com){
        Session session = null;
        Transaction transaction=null;
        int num=0;
        try{
            //调用HibernateSessionFactory获得session
            ActionContext ac=ActionContext.getContext();
            //	Map map=ActionContext.getContext().getSession();
            //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
            //拿到表示request对象 的map
            Map<String, Object> request=ac.getContextMap();
            Map<String, Object> ss=ac.getSession();

            User user=(User) ss.get("user");
            PersonalBook pb=(PersonalBook)ss.get("comPersonnalbook");


            com.setReviewer(user);
            com.setPersonalBook(pb);
            session = sessionFactory.openSession();
            transaction=session.beginTransaction();
            System.out.println("插入："+com.getPersonalBook().getPersonalBookId());
            System.out.println("插入："+com.getReview());

            num=Integer.parseInt(session.save(com).toString());

            transaction.commit(); //写入数据库，




        }catch(Exception ex){
            System.out.println("888888888888444444444444444444");

            ex.printStackTrace();

        }finally{
            //关闭session

            session.close();
        }
        return num;
    }

    public boolean deleteCommentsById(int id){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            //根据id获取要修改的用户数据
            CommentItem commentItem=(CommentItem)session.get(CommentItem.class,id);
            //删除user数据
            Transaction trans=session.beginTransaction();
            session.delete(commentItem);
            trans.commit();
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{//关闭session
            session.close();//调用HibernateSessionFactory的静态方法关闭Session
        }
    }

}
