package com.sharebookssystem.pan.myinterface;

import java.util.List;

public interface CBorrowDataDao {
    public List queryB_BBYUID(int userId, int page);
    public List queryTopFtBooks(String startTime, String endTime, int page);
    public List queryB_BByBID(int booKId, int page);
    public List queryTopCategory(String startTime, String endTime, int page);
    public List queryBookBDByCategory(String category, int page);
}
