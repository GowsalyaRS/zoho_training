package com.atmservice.module;
public class Account 
{
    private static long accountNo= 23418920100L;
    private Customer customer;
    protected  final Long accountNumber;
    private double balance;
    public Account(Customer customer, double balance) 
    {
        this.customer = customer;
        this.accountNumber = ++accountNo;
        this.balance = balance;
    }
    public Account(long accountNumber,Customer customer,double balance)
    {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
    } 
    public Customer getCustomer()
    {
        return customer;
    }
    public Long getAccountNumber() 
    {
        return accountNumber;
    }
    public double getBalance() 
    {
        return balance;
    }
    public void setBalance(double balance) 
    {
        if(balance>0)
        {
           this.balance = Double.parseDouble(String.format("%.2f",balance));
        }
    }
    public static long getAccountNo() 
    {
        return accountNo;
    }
    public static void setAccountNo(long accountNo) 
    {
        Account.accountNo = accountNo;
    }
}