package com.sharebookssystem.model;

import java.util.Objects;

public class CollectCarItem {
    private int collectCarItemId;
    private User user;
    private PersonalBook personalBook;

    public int getCollectCarItemId() {
        return collectCarItemId;
    }

    public void setCollectCarItemId(int collectCarItemId) {
        this.collectCarItemId = collectCarItemId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        CollectCarItem that = (CollectCarItem) o;
        return collectCarItemId == that.collectCarItemId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(collectCarItemId);
    }

    public CollectCarItem() {
    }
}
