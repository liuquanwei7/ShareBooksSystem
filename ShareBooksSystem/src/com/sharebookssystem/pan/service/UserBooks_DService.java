package com.sharebookssystem.pan.service;

import com.sharebookssystem.pan.myinterface.BorrowsDataService;
import com.sharebookssystem.pan.myinterface.CBorrowDataDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("userBooks_DService")
public class UserBooks_DService implements BorrowsDataService {
    @Resource(name = "cBorrowDataDaoImpl")
    private CBorrowDataDao cBorrowDataDao;

    @Override
    public List service() {
        return null;
    }

    public UserBooks_DService() {
    }

    public CBorrowDataDao getcBorrowDataDao() {
        return cBorrowDataDao;
    }

    public void setcBorrowDataDao(CBorrowDataDao cBorrowDataDao) {
        this.cBorrowDataDao = cBorrowDataDao;
    }
}
