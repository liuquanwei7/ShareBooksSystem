package com.sharebookssystem.model;

import java.sql.Date;
import java.util.Objects;

public class BorrowHistoryItem {
    private int borrowHistoryItemId;
    private Date borrowDate;
    private Date shouldReturnDate;
    private Date actualReturnDate;
    private String borrowStatus;
    private User borrower;
    private PersonalBook personalBook;
    private int borrowCode;
    private  String returnCode;;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public int getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(int borrowCode) {
        this.borrowCode = borrowCode;
    }

    public int getBorrowHistoryItemId() {
        return borrowHistoryItemId;
    }

    public void setBorrowHistoryItemId(int borrowHistoryItemId) {
        this.borrowHistoryItemId = borrowHistoryItemId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getShouldReturnDate() {
        return shouldReturnDate;
    }

    public void setShouldReturnDate(Date shouldReturnDate) {
        this.shouldReturnDate = shouldReturnDate;
    }

    public Date getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public String getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(String borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public PersonalBook getPersonalBook() {
        return personalBook;
    }

    public void setPersonalBook(PersonalBook personalBook) {
        this.personalBook = personalBook;
    }



    public BorrowHistoryItem() {
    }
}
