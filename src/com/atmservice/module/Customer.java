package com.atmservice.module;
public class Customer 
{
    private String name;
    private long phoneNo;
    public Customer(String name, long phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    } 
}
