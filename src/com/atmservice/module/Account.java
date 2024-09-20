package com.atmservice.module;
public class Account implements AccountProcess
{
    private static long accountNo= 23418920101L;
    private Customer customer;
    protected  final Long accountNumber;
    private double balance;
    public Account(Customer customer, double balance) {
        this.customer = customer;
        this.accountNumber = accountNo++;
        this.balance = balance;
    }
    public Customer getCustomer(){
        return customer;
    }
    public Long getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public double showBalance() {
        return balance; 
    }
    @Override
    public void deposit(double balance){
         this.balance+=balance;
    }
    @Override
    public void withdraw(double amount) 
    {
        balance-=amount;
    }
    @Override
    public void swipe(double amount) 
    {
        balance=(balance-amount);
    }
    public void swipe (double amount,double cashBack)
    {
       swipe(amount);
       balance+=cashBack;
    }
}