package com.sharebookssystem.bookManagement.dao.hibernate;

import com.sharebookssystem.bookManagement.dao.BookManagementDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

/**
 * Dao的实现类
 * 2018/6/5
 */

public class BookManagementDaoImpl implements BookManagementDao {

    private SessionFactory sessionFactory;

    public BookManagementDaoImpl(){

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //通过Id查询实例
    public Object queryById(Object object,int id){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Object newObject = (Object)session.get(object.getClass(),id);
            transaction.commit();
            return newObject;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    //通过Id删除
    public boolean deleteById(Object object,int id){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Object newObject=(Object) session.get(object.getClass(), id);
            Transaction trans=session.beginTransaction();
            session.delete(newObject);
            trans.commit();
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }

    //通过Object添加或更新
    public boolean updateByObject(Object object){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            Transaction trans=session.beginTransaction();
            session.saveOrUpdate(object);
            trans.commit();
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }

    //一个参数查询
    public List<Object> queryByParam(String className,String param1,String value1){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            String hql = "from "+className+" where "+param1+" = '"+value1+"'";
            Query query = session.createQuery(hql);
            Transaction transaction = session.beginTransaction();
            List<Object> result = query.list();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    //两个参数查询
    public List<Object> queryByParam(String className,String param1,String value1,String param2,String value2){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            String hql = "from "+className+" where "+param1+" = '"+value1+"' and "+param2+" = '"+value2+"'";
            Query query = session.createQuery(hql);
            System.out.println("hql="+hql);
            Transaction transaction = session.beginTransaction();
            List<Object> result = query.list();
            System.out.println("1111"+result.size());
            transaction.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    //三个参数查询
    public List<Object> queryByParam(String className,String param1,String value1,String param2,String value2,String param3,String value3){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            String hql = "from "+className+" where "+param1+" = '"+value1+"' and "+param2+" = '"+value2+"' and "+param3+" = '"+value3+"'";
            Query query = session.createQuery(hql);
            Transaction transaction = session.beginTransaction();
            List<Object> result = query.list();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    //四个参数查询
    public List<Object> queryByParam(String className,String param1,String value1,String param2,String value2,String param3,String value3,String param4,String value4){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            String hql = "from "+className+" where "+param1+" = '"+value1+"' and "+param2+" = '"+value2+"' and "+param3+" = '"+value3+"' and "+param4+" = '"+value4+"'";
            Query query = session.createQuery(hql);
            Transaction transaction = session.beginTransaction();
            List<Object> result = query.list();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    //五个参数查询
    public List<Object> queryByParam(String className,String param1,String value1,String param2,String value2,String param3,String value3,String param4,String value4,String param5,String value5){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            String hql = "from "+className+" where "+param1+" = '"+value1+"' and "+param2+" = '"+value2+"' and "+param3+" = '"+value3+"' and "+param4+" = '"+value4+"' and "+param5+" = '"+value5+"'";
            Query query = session.createQuery(hql);
            Transaction transaction = session.beginTransaction();
            List<Object> result = query.list();
            transaction.commit();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

}
