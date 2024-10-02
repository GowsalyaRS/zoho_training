package com.atmservice.card;
import java.util.Scanner;
import com.atmservice.module.Card;

public class CardView  
{
    protected CardViewModel cardViewModel;
    private Scanner scan  = new Scanner(System.in);;
    CardView(Card card)
    {
        cardViewModel =  new CardViewModel(this,card);
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
    public void swipeDetails(double amount)
    {
        System.out.println("Swipe amount is        : " + amount );
        System.out.println ("Your Current Balance  : " + cardViewModel.showBalance() ); 
    }
    public void depositeView(double amount) 
    {
        System.out.println("Deposit amount is     : " + amount ); 
        System.out.println ("Your Current Balance : " + cardViewModel.showBalance() ); 
    }
    public  void withdrawDetails(double amount) 
    {
        System.out.println("Withdraw amount is    : " + amount );  
        System.out.println ("Your Current Balance : " + cardViewModel.showBalance() ); 
    }
}
