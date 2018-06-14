package com.sharebookssystem.bookUi.dao;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class UserDao {
    SessionFactory sessionFactory;
    public UserDao(){

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean checkLogin(User user){
        Session session = null;
        try{
            //调用HibernateSessionFactory获得session
            session = sessionFactory.openSession();
            //HQL语句, Users是持久化类
            String hql="from User where userAccount=? and userPassword=?";
            System.out.println("4444444444444444444444444444444444444444444444444444444");
            //获得Query对象
            Query query=session.createQuery(hql);
            //设置参数,?的序号从0开始
            query.setParameter(0, user.getUserAccount());
            query.setParameter(1, user.getUserPassword());
            System.out.println("55555555554444444444444444444444444444444444444444444444");

            //执行查询
            List list=query.list();
            System.out.println("666666666666444444444444444444444444444444444");

            if(list.size()>0){
                System.out.println("777777777777777777744444444444444444444444444");
                return true;
            }else{
                System.out.println("999999999999999999994444444444444444444");
                return false;
            }
        }catch(Exception ex){
            System.out.println("888888888888444444444444444444");

            ex.printStackTrace();
            return false;
        }finally{
            //关闭session
            session.close();
        }
    }
    public User queryUserByAccount(User user,String userAccount,String userPassword){
        Session session = null;
        try{
            //调用HibernateSessionFactory获得session
            session = sessionFactory.openSession();
            String queryString="from User where userAccount=? and userPassword=?";
            //创建查询
            Query queryObject=session.createQuery(queryString);
            queryObject.setParameter(0, user.getUserAccount());
            queryObject.setParameter(1, user.getUserPassword());

            List<User> list=queryObject.list();

            user=list.get(0);
            System.out.println("查询成功");
            System.out.println(user.getUserPermission());
            System.out.println(user.getUserId());

            ActionContext ac=ActionContext.getContext();
            //	Map map=ActionContext.getContext().getSession();
            //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
            //拿到表示request对象 的map
            Map<String, Object> request=ac.getContextMap();
            Map<String, Object> ss=ac.getSession();
            ss.put("userPermission",user.getUserPermission());
            ss.put("userId", user.getUserId());
            ss.put("user",user);
            return user;

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
