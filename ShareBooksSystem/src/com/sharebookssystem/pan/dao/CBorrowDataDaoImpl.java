package com.sharebookssystem.pan.dao;

import com.sharebookssystem.pan.myinterface.CBorrowDataDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository("cBorrowDataDaoImpl")
public class CBorrowDataDaoImpl implements CBorrowDataDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List queryB_BBYUID(int userId) {
        Session session = null;
        String hql = "select bi.bookName, bi.bookAuthor, bi.bookPublish, book.Price, bi.bookCategory, " +
                "from BorrowHistoryItem as bhi, PersonalBook as pb, BookInfo as bi " +
                "where bhi.personalBook.personalBookId = pb.personalBookId and pb.user.userId = ? " +
                "group by pb.personalBookId";
        return null;
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
