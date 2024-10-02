package com.atmservice.transaction;
import com.atmservice.datalayer.BankDataLayer;
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
        if(transaction==null)
        {
            System.out.println("No available Transaction History");
            return;
        }
        if(transaction.size()>0)
        {
            transactionView.displayHistory(transaction);
        }
    }
    public void setHistoryData(Transaction transaction) 
    {
        long accountNo =  transaction.getAccountNo();
        Account account = BankDataLayer.getBankDataLayer().getAccount().get(accountNo);
        BankDataLayer.getBankDataLayer().setTransactionHistory(account,transaction);
        account.setBalance(transaction.getCurrentBalance());
    }        
}