package com.sharebookssystem.model;

import java.util.Objects;

public class CommentItem {
    private int commentItemId;
    private String review;
    private User reviewer;
    private PersonalBook personalBook;

    public int getCommentItemId() {
        return commentItemId;
    }

    public void setCommentItemId(int commentItemId) {
        this.commentItemId = commentItemId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public PersonalBook getPersonalBook() {
        return personalBook;
    }

    public void setPersonalBook(PersonalBook personalBook) {
        this.personalBook = personalBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentItem that = (CommentItem) o;
        return commentItemId == that.commentItemId &&
                Objects.equals(review, that.review);
    }

    @Override
    public int hashCode() {

        return Objects.hash(commentItemId, review);
    }

    public CommentItem() {
    }
}
