package com.sharebookssystem.pan.dao;

import com.sharebookssystem.pan.myinterface.CBorrowDataDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository("cBorrowDataDaoImpl")
public class CBorrowDataDaoImpl implements CBorrowDataDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List queryB_BBYUID(int userId, int page) {
        Session session = null;
        //连接三个表，统计一个用户的书籍被借次数
        String hql = "select bi.bookName, bi.bookAuthor, bi.bookPublish, book.Price, bi.bookCategory, count(pb.personalBookId) " +
                "from BorrowHistoryItem as bhi, PersonalBook as pb, BookInfo as bi " +
                "where bhi.personalBook.personalBookId = pb.personalBookId and pb.user.userId = ? " +
                "group by pb.personalBookId "
                + "order by desc";

        try{
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery(hql);
            page = page * 10;
            query.setFirstResult(page);
            query.setMaxResults(10);

            List list = query.list();

            transaction.commit();

            if (list.size() == 0){
                return null;
            }

            //具体数据处理交给Service层
            return list;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("查询用户书籍被借次数失败");
            return null;
        }

    }

    public CBorrowDataDaoImpl() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
