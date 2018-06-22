package com.sharebookssystem.model;

import java.util.List;

public class BookAllInfo {
    List<Book> books;
    List<PersonalBook> personalbooks;

    public BookAllInfo(){

    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<PersonalBook> getPersonalbooks() {
        return personalbooks;
    }

    public void setPersonalbooks(List<PersonalBook> personalbooks) {
        this.personalbooks = personalbooks;
    }
}
