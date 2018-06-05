package com.sharebookssystem.model;


import java.util.Objects;

public class Book {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private String bookPublish;
    private float bookPrice;
    private String bookCategory;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
                Double.compare(book.bookPrice, bookPrice) == 0 &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(bookAuthor, book.bookAuthor) &&
                Objects.equals(bookPublish, book.bookPublish) &&
                Objects.equals(bookCategory, book.bookCategory);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookId, bookName, bookAuthor, bookPublish, bookPrice, bookCategory);
    }

    public Book() {
    }
}
