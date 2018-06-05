package com.sharebookssystem.model;

import java.sql.Date;
import java.util.Objects;

public class PersonalBook {
    private int personalBookId;
    private String bookStatus;
    private int numberOfTimes;
    private Date uploadDate;
    private User user;
    private Book book;

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
