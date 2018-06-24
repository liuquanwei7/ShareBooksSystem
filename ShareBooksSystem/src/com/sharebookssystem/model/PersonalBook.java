package com.sharebookssystem.model;

import java.sql.Date;
import java.util.Objects;

public class PersonalBook {
    private int personalBookId;
    private String bookStatus;//图书状态
    private int numberOfTimes;//借出次数
    private Date uploadDate;//上传日期
    private User user;
    private Book book;
    private int shareCode;
    private String returnCode;
    private String getBookCode;

    public String getGetBookCode() {
        return getBookCode;
    }

    public void setGetBookCode(String getBookCode) {
        this.getBookCode = getBookCode;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public int getShareCode() {
        return shareCode;
    }

    public void setShareCode(int shareCode) {
        this.shareCode = shareCode;
    }

    public int getPersonalBookId() {
        return personalBookId;
    }

    public void setPersonalBookId(int personalBookId) {
        this.personalBookId = personalBookId;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(int numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalBook that = (PersonalBook) o;
        return personalBookId == that.personalBookId &&
                numberOfTimes == that.numberOfTimes &&
                Objects.equals(bookStatus, that.bookStatus) &&
                Objects.equals(uploadDate, that.uploadDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(personalBookId, bookStatus, numberOfTimes, uploadDate);
    }

    public PersonalBook() {
    }
}
