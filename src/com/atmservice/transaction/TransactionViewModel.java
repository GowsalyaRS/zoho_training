package com.atmservice.transaction;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.filedatabase.Writer;
import com.atmservice.module.Account;
import com.atmservice.module.Transaction;
import java.util.Map;
import java.util.ArrayList;

public class TransactionViewModel
{
    private TransactionView transactionView;
    private Map <Account,ArrayList<Transaction>> transactionHistory;
    public TransactionViewModel(TransactionView transactionView) 
    {
        this.transactionView =transactionView;  
        transactionHistory =  BankDataLayer.getInstance().getAccountHistory();
    }
    public TransactionViewModel()
    {
    }
    public void getHistory(Account account) 
    {
        ArrayList <Transaction> transaction =  transactionHistory.get(account);
        if(transaction.size()>0)
        {
            transactionView.displayHistory(transaction);
        }
        else
        {
            System.out.println("No available Transaction History");
        }
    }
    public void setHistoryData(Transaction transaction) 
    {
        long accountNo =  transaction.getAccountNo();
        Map <Long,Account> accounts  = BankDataLayer.getBankDataLayer().getAccount();
        Account account = accounts.get(accountNo);
        BankDataLayer.getBankDataLayer().setTransactionHostory(account,transaction);
        try
        {
            Writer.writeTransactionFile(transaction);
            account.setBalance(transaction.getCurrentBalance());
            Writer.modifyAccountFile(BankDataLayer.getInstance().getAccount());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }        
}