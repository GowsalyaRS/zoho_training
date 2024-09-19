package com.atmservice.module;
interface Accountprocess
{
    double showBalance();
    String withdraw(double amount);
    void deposit(double amount);
    String swipe(double amount); 
}
