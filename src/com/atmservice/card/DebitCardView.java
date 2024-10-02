package com.atmservice.card;
import com.atmservice.module.Card;

public class DebitCardView  extends CardView
{
    private DebitCardViewModel debitCardViewModel;
    public DebitCardView(Card card)
    {
        super(card);
        debitCardViewModel = new  DebitCardViewModel(this,card);
    } 
    public void swipeDetails(double cashback) 
    {
        System.out.println("You get a cashBack :   " + cashback );
    }
    public void withdrawDetails(double calculatedCharge) 
    {
        System.out.println("Your  debited  charge   :  " + calculatedCharge );
    }
    public DebitCardViewModel getInstance() 
    {
        return debitCardViewModel;
    }
    
}
