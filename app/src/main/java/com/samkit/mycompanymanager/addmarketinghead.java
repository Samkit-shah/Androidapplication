package com.samkit.mycompanymanager;

public class addmarketinghead {

    private int id;
    private String name;
    private int contact;
    private String address;
    private String qualification;
    private String password;
    private String salary;
    private String created_at;
    private String updated_at;

    public addmarketinghead(int id, String name, int contact, String address, String qualification, String password, String salary) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.qualification = qualification;
        this.password = password;
        this.salary = salary;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getContact() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(int contact) {
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
