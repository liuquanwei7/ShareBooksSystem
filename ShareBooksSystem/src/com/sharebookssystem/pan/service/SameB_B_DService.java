package com.sharebookssystem.pan.service;

import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.User;
import com.sharebookssystem.pan.myinterface.BorrowsDataService;
import com.sharebookssystem.pan.myinterface.CBorrowDataDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service("sameB_B_DService")
public class SameB_B_DService implements BorrowsDataService {
    @Resource(name = "cBorrowDataDaoImpl")
    private CBorrowDataDao cBorrowDataDao;

    public SameB_B_DService() {
    }

    @Override
    public List service(User user, int page) {
        return null;
    }

    @Override
    public List service(Date startTime, Date endTime, int page) {
        return null;
    }

    @Override
    public List service(Book book, int page) {
        List list = cBorrowDataDao.queryB_BByBID(book.getBookId(), page);
        if (list == null) return null;

        List info = new ArrayList();

        for (int i = 0; i < list.size(); i++){
            Object[] o = (Object[])list.get(i);

            List line = new ArrayList();

            String userName = o[0].toString();
            line.add(userName);
            String bookName = o[1].toString();
            line.add(bookName);
            String bookAuthor = o[2].toString();
            line.add(bookAuthor);
            String bookPublish = o[3].toString();
            line.add(bookPublish);
            String bookPrice = o[4].toString();
            line.add(bookPrice);
            String bookCategory = o[5].toString();
            line.add(bookCategory);
            int times = Integer.parseInt(o[6].toString());
            line.add(times);

            info.add(line);
        }

        return info;
    }

    @Override
    public List service(String category, int page) {
        return null;
    }

    public CBorrowDataDao getcBorrowDataDao() {
        return cBorrowDataDao;
    }

    public void setcBorrowDataDao(CBorrowDataDao cBorrowDataDao) {
        this.cBorrowDataDao = cBorrowDataDao;
    }
}
