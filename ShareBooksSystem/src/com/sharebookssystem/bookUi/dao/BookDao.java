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
            if(list.size()>0){
                list=list;

                for(int i=0;i<length;i++){
                    bd=list.get(i);
                    ss.put("book",bd);
                }
                  ss.put("books",list);//存入所有未还书籍
                return list;
            }else{
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

    public boolean queryReturnActionById(PersonalBook pb,int userid,int borrowHistoryItemId){
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
            System.out.println("分界线");


            String rc=getStringRandom(8);
            String queryString="from BorrowHistoryItem where borrowHistoryItemId=?";
            //创建查询
            Query queryObject=session.createQuery(queryString);
            queryObject.setParameter(0, borrowHistoryItemId);
//            queryObject.setParameter(1,pb.getPersonalBookId());
            List<BorrowHistoryItem> listB=queryObject.list();
            if(listB.size()>0){
                listB=listB;


                BorrowHistoryItem bd=listB.get(0);
                bd.setBorrowStatus("请求归还");
                System.out.println("测试"+bd.getBorrowHistoryItemId());

                System.out.println("测试"+bd.getBorrowStatus());


                String hql="from PersonalBook where personalBookId="+bd.getPersonalBook().getPersonalBookId(); //查询personalbooks
                //创建查询
                Query query=session.createQuery(hql);
    //            query.setParameter(0,bd.getPersonalBook().getPersonalBookId() );

                //设置参数,?的序号从0开始

                System.out.println("555555555544444444444444444444444444444444");
    //            List<Book> list=queryObject.list();
                List<PersonalBook> list=query.list();
                if(list.size()>0){
                    list=list;

                    pb=list.get(0);
                    pb.setBookStatus("请求归还");
        //            for(int i=0;i<listB.size();i++) {
        //                if (listB.get(i).getBorrowStatus().equals("未还")) {
        //
        //                    bd = listB.get(i);
        //
        //
        //                    pb.setBookStatus("请求归还");
        //                    break;
        //                }
        //
        //            }
                    transaction=session.beginTransaction();
                    bd.setReturnCode(rc);
                    session.update(bd);
                    session.update(pb);


                    User user=(User) ss.get("user");
                    transaction.commit(); //写入数据库，
                    MailUitls.sendMail(user.getUserEmail(),"还书码"+rc);
        //            ss.put("returnCode",rc);
                    ss.put("ReturnMessage","获取还书码"+rc);
                    return true;
                    }
                    else{
                        list=null;
                        return false;
                    }

            } else{
                listB=null;
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



}
