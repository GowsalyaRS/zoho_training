package com.atmservice.filedatabase;
import java.util.List;
import com.atmservice.module.Transaction;

public interface TransactionFileProcess 
{
    List<Transaction> readTransactionFile() throws Exception;
    void writeTransactionFile(Transaction transaction)  throws Exception;
}
