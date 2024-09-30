package com.atmservice.card;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.filedatabase.Writer;
import com.atmservice.module.Card;
import com.atmservice.module.Transaction;
import com.atmservice.module.TransferType;
import com.atmservice.service.CardProcess;
import java.util.Scanner;
import com.atmservice.transaction.TransactionViewModel;

public class CardView  implements CardProcess
{
    protected CardViewModel cardViewModel;
    private Scanner scan;
    protected Card card;
    private TransactionViewModel transactionViewModel;
    CardView(Card card)
    {
        cardViewModel = new CardViewModel(this);
        this.card = card;
        transactionViewModel = new  TransactionViewModel();
        scan = new Scanner(System.in);
    }
    public void swipe()
    {
        double amount = isValidAmount();
        if (cardViewModel.isVaidAmount(amount,card))
        {
            swipe(amount);
            Transaction transaction = new Transaction(card.getAccountNo(), TransferType.SWIPE, amount, card.getBalance());
            transactionViewModel.setHistoryData(transaction);
        }
    }
    public void swipe(double amount) 
    {
        cardViewModel.debitProcess(amount,card);
        System.out.println("Swipe amount is : " + amount );
        displayBalance();   
    }
    public double showBalance() 
    {
        return card.getBalance();
    }
    public void withdraw ()
    {
        double amount = isValidAmount();
        if (cardViewModel.isVaidAmount(amount,card))
        {
            withdraw(amount);
            Transaction transaction = new Transaction(card.getAccountNo(), TransferType.WITHDRAW, amount, card.getBalance());
            transactionViewModel.setHistoryData(transaction);
        }
    }
    public void withdraw(double amount) 
    {
        cardViewModel.debitProcess(amount,card);
        System.out.println("Withdraw amount is : " + amount );  
        displayBalance(); 
    }
    public void displayBalance()
    {
        System.err.println(" Your Current Balance  : " + card.getBalance());
    }
    public void deposit() 
    {
        double amount = isValidAmount();
        try
        {
           deposit(amount);
        }
        catch (Exception e)
        {
           Writer.printMsg();
        } 
    }
    public void deposit(double amount) throws Exception 
    {
        card.setBalance(card.getBalance()+amount); 
        System.out.println("Deposit amount is : " + amount ); 
        Transaction transaction = new Transaction(card.getAccountNo(),TransferType.DEPOSIT,amount,card.getBalance());
        transactionViewModel.setHistoryData(transaction);
        displayBalance();
    }
    public double isValidAmount()
    {
        boolean flag = true;
        double amount =0;
        while(flag)
        {
           System.out.println("Enter the Amount ");
           amount =scan.nextDouble();
           if(amount>0)
           {
              flag = false;
           }
        }
        return amount;
    }
}
