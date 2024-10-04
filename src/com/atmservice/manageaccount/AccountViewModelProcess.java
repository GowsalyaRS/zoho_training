package com.atmservice.manageaccount;
import com.atmservice.module.Account;
import com.atmservice.module.Customer;

public interface AccountViewModelProcess 
{
    void createAccount(Customer customer, double amount);
    boolean validAmount(double amount);
    Account validAccount(long accountNumber);
    void provideDebitCard(Account account);
}
