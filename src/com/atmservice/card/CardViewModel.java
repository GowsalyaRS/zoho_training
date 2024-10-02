package com.atmservice.card;
import com.atmservice.login.LoginView;
import com.atmservice.module.Card;
import com.atmservice.module.Transaction;
import com.atmservice.module.TransferType;
import com.atmservice.service.CardProcess;
import com.atmservice.transaction.TransactionViewModel;

public class CardViewModel implements CardProcess
{
    private CardView cardView;
    private TransactionViewModel transactionViewModel;
    protected Card card;
    public CardViewModel(CardView cardView,Card card) 
    {
        this.cardView = cardView ;
        this.card = card;
        transactionViewModel = new  TransactionViewModel();
    }
    public boolean isVaidAmount(double amount) 
    {
        if(card.getBalance()<amount) 
        {
            LoginView.alert("InSufficient Balance"); 
            return false;
        }
        return true;
    }
    public void debitProcess(double amount) 
    {
        card.setBalance(card.getBalance()-amount);
    }
    public void swipe()
    {
        double amount = cardView.isValidAmount();
        if (isVaidAmount(amount))
        {
            swipe(amount);
            Transaction transaction = new Transaction(card.getAccountNo(), TransferType.SWIPE, amount, card.getBalance());
            transactionViewModel.setHistoryData(transaction);
        }
    }
    public void swipe(double amount) 
    {
        debitProcess(amount);
        cardView.swipeDetails(amount);
    }
     public void deposit() 
    {
        double amount = cardView.isValidAmount();
        deposit(amount);
        cardView.depositeView(amount);
    }
    public void deposit(double amount) 
    {
        card.setBalance(card.getBalance()+amount); 
        Transaction transaction = new Transaction(card.getAccountNo(),TransferType.DEPOSIT,amount,card.getBalance());
        transactionViewModel.setHistoryData(transaction);
    }
    public void withdraw ()
    {
        double amount = cardView.isValidAmount();
        if (isVaidAmount(amount))
        {
            withdraw(amount);
            Transaction transaction = new Transaction(card.getAccountNo(), TransferType.WITHDRAW, amount, card.getBalance());
            transactionViewModel.setHistoryData(transaction);
        }
    }
    public void withdraw(double amount) 
    {
        debitProcess(amount);
        cardView.withdrawDetails(amount);
    }
    public double showBalance() 
    {
        return card.getBalance();
    }
}
