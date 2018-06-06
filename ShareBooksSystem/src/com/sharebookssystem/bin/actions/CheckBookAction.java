package com.sharebookssystem.bin.actions;

import com.sharebookssystem.bin.dao.BookDao;

public class CheckBookAction {
    BookDao bd;

    public BookDao getBd() {
        return bd;
    }

    public void setBd(BookDao bd) {
        this.bd = bd;
    }
}
