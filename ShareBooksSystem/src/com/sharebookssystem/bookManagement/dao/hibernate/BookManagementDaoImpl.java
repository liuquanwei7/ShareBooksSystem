package com.sharebookssystem.bookManagement.dao.hibernate;

import com.opensymphony.xwork2.ActionContext;
import com.sharebookssystem.bookManagement.dao.BookManagementDao;
import com.sharebookssystem.model.Manager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Dao的实现类
 * 2018/6/5
 */

@Repository("bookManagementDao")
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




    //查询管理员账户
    public boolean queryManager(Manager manager){
        boolean flag = true;
        Session session = null;
        try{
            session = sessionFactory.openSession();
            String hql = "from Manager where managerAccount = ? and managerPassword = ?";
            Query query = session.createQuery(hql);
            query.setParameter(0,manager.getManagerAccount());
            query.setParameter(1,manager.getManagerPassword());
            List<Manager> list = query.list();
            Map s = ActionContext.getContext().getSession();
            if(list.size()==0){
                flag = false;
            }else{
                s.put("managerId",list.get(0).getManagerId());
                System.out.println("managerId="+s.get("managerId"));
            }
            return flag;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }
}
