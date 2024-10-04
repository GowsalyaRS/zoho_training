package com.atmservice.transaction;
import java.util.ArrayList;
import com.atmservice.manageaccount.ManageAccountView;
import com.atmservice.module.Account;
import com.atmservice.module.Transaction;

public class TransactionView implements TransactionViewProcess
{
    private TransactionViewModelProcess transactionViewModel;
    public TransactionView(TransactionViewModelProcess transactionViewModel)
    {
        this.transactionViewModel = transactionViewModel;
    }
    public void  printAccountNumber()
    {
        Account account = ManageAccountView.findAccount();
        if(account!=null)
        {
            System.out.println("Your Account Number is "+ account.getAccountNumber());
            transactionViewModel.findHistory(account);
        }
        else
        {
            System.out.println("Account Number is Invalid..!");
        }
    }
    public void printHistory(ArrayList<Transaction> transactions) 
    {
        System.out.println("Transaction Id      Date         Time          Amount      charge/cashback      Current Balance       Transaction Type ");
        for(Transaction transaction : transactions)
        {
            System.out.println(transaction);
        }
    }
}