package com.sharebookssystem.bookUi.dao;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.bookUi.utils.MailUitls;
import com.sharebookssystem.model.CommentItem;
import com.sharebookssystem.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.SendFailedException;


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
            if(list.size()>0){
                list=list;
            }else{
                list=null;
            }
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
            if(list.size()>0){

                user=list.get(0);


            ActionContext ac=ActionContext.getContext();
            //	Map map=ActionContext.getContext().getSession();
            //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
            //拿到表示request对象 的map
//            Map<String, Object> request=ac.getContextMap();
            Map<String, Object> ss=ac.getSession();
            ss.put("userPermission",user.getUserPermission());
            ss.put("userId", user.getUserId());
            ss.put("user",user);
            return user;

            }else{
                list=null;
                user=null;
                return user;
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
    public String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {

             String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    //注册用户
    public int registerUser(User user){
        int num=0;
        //得到session
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            num=Integer.parseInt(session.save(user).toString());
            transaction.commit(); //写入数据库，
        }catch (Exception e) {
            e.printStackTrace();
            num=0;
        }finally{//关闭session
            session.close();//调用HibernateSessionFactory的静态方法关闭Session
        }
        return num;
    }

    public List<User> queryUsersById(User user){
        Session session = null;
        try{
            //调用HibernateSessionFactory获得session
            session = sessionFactory.openSession();

            ActionContext ac=ActionContext.getContext();
            //	Map map=ActionContext.getContext().getSession();
            //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
            //拿到表示request对象 的map
            Map<String, Object> request=ac.getContextMap();
            Map<String, Object> ss=ac.getSession();
            List<CommentItem> cts=(List<CommentItem>) ss.get("allComments");
            if(cts.size()>0){
                    cts=cts;

                System.out.println("review:"+cts.get(0).getReview());
                String hql="";
                int length=cts.size();
                System.out.println("UserName:"+cts.get(0).getReviewer().getUserId());
                System.out.println("length"+length);
                for(int i=0;i<length;i++){
                    hql=hql+cts.get(i).getReviewer().getUserId();
                    if((i+1)!=length){
                        hql=hql+",";
                    }
                }

                System.out.println("hql"+hql);

                String queryString="from User where userId in("+hql+")";
                //创建查询
                Query queryObject=session.createQuery(queryString);


                List<User> list=queryObject.list();
                if(list.size()>0){
                    list=list;
                }else{
                    list=null;
                }
    //            System.out.println("hql"+list.get(3).getUserName());
                System.out.println("查询成功");
                //存储评论的user
                ss.put("CommentUsername", list);
                return list;
            }
            else{
                cts=null;
                List<User> list=null;
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


    public boolean changeUser(User user){
        int num=0;
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();

             session.update(user);
            transaction.commit(); //写入数据库，
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{//关闭session
            session.close();//调用HibernateSessionFactory的静态方法关闭Session
        }

    }

    public boolean checkRegisterEmail(User user){
        Session session = null;
        try{
            //调用HibernateSessionFactory获得session
            session = sessionFactory.openSession();

            String queryString="from User where userAccount=?";
            //创建查询
            Query queryObject=session.createQuery(queryString);
            queryObject.setParameter(0, user.getUserAccount());

            List<User> list=queryObject.list();
                //HQL语句, Users是持久化类
                ActionContext ac=ActionContext.getContext();
                //	Map map=ActionContext.getContext().getSession();
                //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
                //拿到表示request对象 的map
                Map<String, Object>  request=ac.getContextMap();
                Map<String, Object> ss=ac.getSession();
                ss.remove("checkPass");

                String code=getStringRandom(5);

                // 发送激活邮件;
                System.out.println("尝试发送");
                MailUitls.sendMail(user.getUserEmail(),code);
                ss.put("code",code);
                ss.put("user",user);
               return true;


        }catch(Exception ex){
            System.out.println("888888888888444444444444444444");

            ex.printStackTrace();
            return false;
        }finally{
            //关闭session
            session.close();
        }
    }


    public boolean checkNewEmail(User user){
        Session session = null;
        try{
            //调用HibernateSessionFactory获得session
            session = sessionFactory.openSession();
            //HQL语句, Users是持久化类
            ActionContext ac=ActionContext.getContext();
            //	Map map=ActionContext.getContext().getSession();
            //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
            //拿到表示request对象 的map
            Map<String, Object>  request=ac.getContextMap();
            Map<String, Object> ss=ac.getSession();
            ss.remove("checkPass");

            String code=getStringRandom(5);

            // 发送激活邮件;
            System.out.println("尝试发送");
            MailUitls.sendMail(user.getUserEmail(),"验证码"+code);
            ss.put("code",code);
            ss.put("newuser",user);
            return true;
        }catch(Exception ex){
            System.out.println("888888888888444444444444444444");

            ex.printStackTrace();
            return false;
        }finally{
            //关闭session
            session.close();
        }
    }
}
