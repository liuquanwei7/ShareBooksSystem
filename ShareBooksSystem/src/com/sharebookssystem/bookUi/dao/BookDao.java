package com.sharebookssystem.bookUi.dao;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.bookUi.utils.MailUitls;
import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.BorrowHistoryItem;
import com.sharebookssystem.model.PersonalBook;
import com.sharebookssystem.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BookDao {
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<Book> queryBooks(Book bd){
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
            System.out.println(length);
            a=(int[]) ss.get("pdarray");
            System.out.println(a[0]);
            for(int i=0;i<length;i++){
                hql=hql+a[i];
                if((i+1)!=length){
                    hql=hql+",";
                }
                System.out.println(a[i]);
            }

            System.out.println(hql);
            System.out.println("检查hql");
            session = sessionFactory.openSession();
            String queryString="from Book where BookId in("+hql+")";
            //创建查询
            Query queryObject=session.createQuery(queryString);
            List<Book> list=queryObject.list();
            for(int i=0;i<length;i++){
                bd=list.get(i);
                ss.put("book",bd);
            }
              ss.put("books",list);
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

    public boolean queryReturnActionById(PersonalBook pb,int userid,int bookid){
        Session session = null;
        Transaction transaction=null;
        try{
            //调用HibernateSessionFactory获得session
            ActionContext ac=ActionContext.getContext();
            //	Map map=ActionContext.getContext().getSession();
            //得到Strust对HttpServletRequest对象进行了封装，封装为了一个Map
            //拿到表示request对象 的map
            Map<String, Object> request=ac.getContextMap();
            Map<String, Object> ss=ac.getSession();



            session = sessionFactory.openSession();



            String hql="from PersonalBook where bookId=? and userId=?";
            //创建查询
            Query query=session.createQuery(hql);
            //设置参数,?的序号从0开始
            query.setParameter(0, bookid);
            query.setParameter(1, userid);
            System.out.println("555555555544444444444444444444444444444444");
//            List<Book> list=queryObject.list();
            List<PersonalBook> list=query.list();
            pb= list.get(0);
            String rc=getStringRandom(8);


            System.out.println("Person测试"+pb.getPersonalBookId());
            System.out.println("user测试"+userid);

            String queryString="from BorrowHistoryItem where borrowerId=? and personalBookId=?";
            //创建查询
            Query queryObject=session.createQuery(queryString);
            queryObject.setParameter(0, userid);
            queryObject.setParameter(1,pb.getPersonalBookId());
            List<BorrowHistoryItem> listB=queryObject.list();
            BorrowHistoryItem bd=listB.get(0);

            for(int i=0;i<listB.size();i++) {
                if (listB.get(i).getBorrowStatus().equals("未还")) {

                    bd = listB.get(i);
                    bd.setReturnCode(rc);
                    bd.setBorrowStatus("请求归还");
                    pb.setBookStatus("请求归还");
                    break;
                }

            }
            transaction=session.beginTransaction();

            session.update(bd);
            session.update(pb);


            User user=(User) ss.get("user");
            transaction.commit(); //写入数据库，
            MailUitls.sendMail(user.getUserEmail(),"还书码"+rc);
//            ss.put("returnCode",rc);
            ss.put("ReturnSuccess","获取还书码"+rc);
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
