package com.atmservice.transaction;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.filedatabase.AccountFile;
import com.atmservice.filedatabase.TransactionFile;
import com.atmservice.login.LoginView;
import com.atmservice.module.Account;
import com.atmservice.module.Transaction;
import java.util.ArrayList;

public class TransactionViewModel implements TransactionViewModelProcess
{
    private TransactionViewProcess transactionView;
   
    public void setTransactionView(TransactionViewProcess transactionView) 
    {
        this.transactionView = transactionView;
    }
    public void findHistory(Account account) 
    {
        ArrayList <Transaction> transaction = BankDataLayer.getInstance().getAccountHistory().get(account);
        if(transaction==null)
        {
            LoginView.alert("No available Transaction History");
            return;
        }
        if(transaction.size()>0)
        {
            transactionView.printHistory(transaction);
        }
    }
    public void setHistoryData(Transaction transaction) 
    {
        long accountNo =  transaction.getAccountNo();
        Account account = BankDataLayer.getBankDataLayer().getAccount().get(accountNo);
        BankDataLayer bank =  BankDataLayer.getBankDataLayer();
        bank.setAccountFile(new AccountFile());  // Inject account data
        bank.setTransactionFile(new TransactionFile()); // Inject trasaction data
        bank.setTransactionHistory(account,transaction);
        account.setBalance(transaction.getCurrentBalance());
    }
}