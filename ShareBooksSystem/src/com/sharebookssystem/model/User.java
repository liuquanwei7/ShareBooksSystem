package com.sharebookssystem.model;

import java.util.Objects;

public class User {
    private int userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private String userIdentity;
    private String userGender;
    private int userAge;
    private int userPermission;
    private String userEmail;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(int userPermission) {
        this.userPermission = userPermission;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                userAge == user.userAge &&
                userPermission == user.userPermission &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userAccount, user.userAccount) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(userIdentity, user.userIdentity) &&
                Objects.equals(userGender, user.userGender);

    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public User() {
    }
}
