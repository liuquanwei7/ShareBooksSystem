package com.sharebookssystem.pan.service;

import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.User;
import com.sharebookssystem.pan.myinterface.BorrowsDataService;
import com.sharebookssystem.pan.myinterface.CBorrowDataDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("topFtBPageService")
public class TopFtBPageService implements BorrowsDataService {
    @Resource(name = "cBorrowDataDaoImpl")
    private CBorrowDataDao cBorrowDataDao;

    @Override
    public List service(User user, int page) {
        return null;
    }

    @Override
    public List service(Date startTime, Date endTime, int page) {
        java.util.Date nowDate = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        now.setTime(nowDate);
        java.util.Date endDate = now.getTime();
        now.add(Calendar.MONTH, -1);
        java.util.Date startDate = now.getTime();

        if (startTime == null) startTime = new Date(startDate.getTime());
        if (endTime == null) endTime = new Date(endDate.getTime());

        String startTimeString = sdf.format(startTime);
        String endTimeString = sdf.format(endTime);

        System.out.println(startTimeString);
        System.out.println(endTimeString);

        List list = cBorrowDataDao.queryTopFtBooks(startTimeString, endTimeString, page);

        if (list == null) return null;

        List<List> info = new ArrayList<List>();

        for (int i = 0; i < list.size(); i++){
            Object[] o = (Object[])list.get(i);

            List line = new ArrayList();

            String userIdString = o[0].toString();
            line.add(Integer.parseInt(userIdString));
            String bookIdString = o[1].toString();
            line.add(Integer.parseInt(bookIdString));
            String userName = o[2].toString();
            line.add(userName);
            String bookName = o[3].toString();
            line.add(bookName);
            String bookAuthor = o[4].toString();
            line.add(bookAuthor);
            String bookPublish = o[5].toString();
            line.add(bookPublish);
            String bookPrice = o[6].toString();
            line.add(bookPrice);
            String bookCategory = o[7].toString();
            line.add(bookCategory);
            int times = Integer.parseInt(o[8].toString());
            line.add(times);

            info.add(line);
        }

        return info;
    }

    @Override
    public List service(String category, int page) {
        return null;
    }

    @Override
    public List service(Book book, int page) {
        return null;
    }

    public TopFtBPageService() {
    }

    public CBorrowDataDao getcBorrowDataDao() {
        return cBorrowDataDao;
    }

    public void setcBorrowDataDao(CBorrowDataDao cBorrowDataDao) {
        this.cBorrowDataDao = cBorrowDataDao;
    }
}
