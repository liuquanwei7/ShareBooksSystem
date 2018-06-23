package com.sharebookssystem.model;

import java.util.Objects;

public class Manager {
    private int managerId;
    private String managerAccount;
    private String managerPassword;
    private String managerName;
    private String managerGender;
    private int managerAge;
    private int managerPermission;

    public Manager() {
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerGender() {
        return managerGender;
    }

    public void setManagerGender(String managerGender) {
        this.managerGender = managerGender;
    }

    public int getManagerAge() {
        return managerAge;
    }

    public void setManagerAge(int managerAge) {
        this.managerAge = managerAge;
    }

    public int getManagerPermission() {
        return managerPermission;
    }

    public void setManagerPermission(int managerPermission) {
        this.managerPermission = managerPermission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return managerId == manager.managerId &&
                Objects.equals(managerAccount, manager.managerAccount) &&
                Objects.equals(managerPassword, manager.managerPassword);
    }

    @Override
    public int hashCode() {

        return Objects.hash(managerId, managerAccount, managerPassword);
    }

}
