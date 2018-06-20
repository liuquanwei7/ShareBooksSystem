package com.sharebookssystem.pan.myinterface;

import com.sharebookssystem.model.Book;
import com.sharebookssystem.model.User;

import java.sql.Date;
import java.util.List;

public interface BorrowsDataService {
    public List service(User user, int page);
    public List service(Date startTime, Date endTime, int page);
    public List service(Book book, int page);
    public List service(String category, int page);
}
