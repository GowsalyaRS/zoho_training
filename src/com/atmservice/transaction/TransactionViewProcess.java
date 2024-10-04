package com.atmservice.transaction;
import java.util.ArrayList;
import com.atmservice.module.Transaction;

public interface TransactionViewProcess 
{
    void printHistory(ArrayList<Transaction> transactions);
    public void printAccountNumber();
}
