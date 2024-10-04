package com.atmservice.card;

public class DebitCardView  extends CardView implements DebitCardViewProcess
{
    private DebitCardViewModelProcess debitCardViewModel;
    public DebitCardView(CardViewModelProcess  cardViewModel,DebitCardViewModelProcess debitCardViewModel)
    {
        super(cardViewModel);
        this.debitCardViewModel = debitCardViewModel;
    } 
    public void swipeDetails(double cashback) 
    {
        System.out.println("You get a cashBack :   " + cashback );
    }
    public void withdrawDetails(double calculatedCharge) 
    {
        System.out.println("Your  debited  charge   :  " + calculatedCharge );
    }
}
