package com.atmservice.card;
import com.atmservice.module.Card;
import com.atmservice.service.AccountProcess;
import com.atmservice.service.CardProcess;
import java.util.Scanner;

public class CardView  implements AccountProcess,CardProcess
{
    protected CardViewModel cardViewModel;
    private Scanner scan;
    protected Card card;
    CardView(Card card)
    {
        cardViewModel = new CardViewModel(this);
        this.card = card;
        scan = new Scanner(System.in);
    }
    public void swipe()
    {
        double amount = isValidAmount();
        if (cardViewModel.isVaidAmount(amount,card))
        {
            swipe(amount);
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
        deposit(amount);
    }
    public void deposit(double amount) 
    {
        card.setBalance(card.getBalance()+amount); 
        System.out.println("Deposit amount is : " + amount ); 
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
