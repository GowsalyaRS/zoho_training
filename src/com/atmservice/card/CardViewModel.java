package com.atmservice.card;
import com.atmservice.login.LoginView;
import com.atmservice.module.Card;
import com.atmservice.module.Transaction;
import com.atmservice.module.TransferType;
import com.atmservice.service.CardProcess;
import com.atmservice.transaction.TransactionViewModel;

public class CardViewModel implements CardProcess,CardViewModelProcess
{
    private CardViewProcess cardView;
    protected TransactionViewModel transactionViewModel;
    protected Card card;
    public CardViewModel(Card card)
    {
      this.card = card;
    }
    public void setCardView(CardViewProcess cardView) 
    {
        this.cardView = cardView;
    }
    public CardViewProcess getCardView() 
    {
        return cardView;
    }
    public void setTransactionViewModel(TransactionViewModel transactionViewModel) 
    {
        this.transactionViewModel = transactionViewModel;
    }
    public boolean isVaidAmounts(double amount) 
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
        double amount = cardView.isEnterValidAmount();
        if (isVaidAmounts(amount))
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
        double amount = cardView.isEnterValidAmount();
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
        double amount = cardView.isEnterValidAmount();
        if (isVaidAmounts(amount))
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
       System.out.println(card);
        return card.getBalance();
    }
    public double getBalance() 
    {
        return showBalance();
    }
}
