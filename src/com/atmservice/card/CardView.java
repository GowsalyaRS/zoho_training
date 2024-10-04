package com.atmservice.card;
import java.util.Scanner;
public class CardView  implements CardViewProcess
{
    protected CardViewModelProcess cardViewModel;
    private Scanner scan  = new Scanner(System.in);;
    public CardView(CardViewModelProcess cardViewModel)
    {
        this.cardViewModel = cardViewModel; 
    }
    public double isEnterValidAmount()
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
        System.out.println ("Your Current Balance  : " + cardViewModel.getBalance() ); 
    }
    public void depositeView(double amount) 
    {
        System.out.println("Deposit amount is     : " + amount ); 
        System.out.println ("Your Current Balance : " + cardViewModel.getBalance() ); 
    }
    public  void withdrawDetails(double amount) 
    {
        System.out.println("Withdraw amount is    : " + amount );  
        System.out.println ("Your Current Balance : " + cardViewModel.getBalance() ); 
    }
}
