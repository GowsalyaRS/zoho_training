package com.atmservice.transaction;
import java.util.ArrayList;
import com.atmservice.manageaccount.ManageAccountView;
import com.atmservice.module.Account;
import com.atmservice.module.Transaction;

public class TransactionView
{
    private TransactionViewModel transactionViewModel;
    public TransactionView()
    {
        transactionViewModel = new TransactionViewModel(this);
    }
    public Account findAccount() 
    {
        Account account = new ManageAccountView().findAccount();
        return account;
    }
    public void  getHistory()
    {
        Account account = findAccount();
        if(account!=null)
        {
           transactionViewModel.getHistory(account);
        }
        else
        {
            System.out.println("Account Number is Invalid..!");
        }
    }
    public void displayHistory(ArrayList<Transaction> transactions) 
    {
        System.out.println("Transaction Id      Date         Time          Amount      charge/cashback      Current Balance       Transaction Type ");
        for(Transaction transaction : transactions)
        {
            System.out.println(transaction);
        }
    }
}