package com.atmservice.module;
interface AccountProcess
{
    double showBalance();
    void withdraw(double amount);
    void deposit(double amount);
    void swipe(double amount); 
}
