package com.samkit.mycompanymanager;

import java.math.BigInteger;

public class getmarketingheaddetails {
    private BigInteger id;
    private String name;
    private BigInteger contact;
    private String address;
    private String qualification;
    private String password;
    private String salary;

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigInteger getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getQualification() {
        return qualification;
    }

    public String getPassword() {
        return password;
    }

    public String getSalary() {
        return salary;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(BigInteger contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
