package com.atmservice.transaction;
import com.atmservice.module.Account;
import com.atmservice.module.Transaction;

public interface TransactionViewModelProcess 
{
    void findHistory(Account account);
    void setHistoryData(Transaction transaction) ;
}
