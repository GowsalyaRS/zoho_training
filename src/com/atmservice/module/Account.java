package com.atmservice.module;
public  class Account implements Accountprocess
{
    private Customer customer;
    protected Long accountNumber;
    private double balance;
    public Account(Customer customer,Long accountNumber, double balance) {
        this.customer = customer;
        this.accountNumber = accountNumber;
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
    public String withdraw(double amount) 
    {
        if(amount<=balance)
        {
            balance-=amount;
            return "Withdraw Successfully...!   USD " + amount;
        }
        return "Amount is Invalid " + amount;
    }
    @Override
    public String swipe(double amount) 
    {
        if(amount<=balance)
        {
            balance-=amount;
            return "Swipe Successfully...!   USD " + amount;
        }
        return "Amount is Invalid " + amount;
    }
}