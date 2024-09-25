package com.atmservice.card;
import com.atmservice.module.Card;

public class DebitCardView  extends CardView
{
    private DebitCardViewModel debitCardViewModel;
    public DebitCardView(Card card)
    {
        super(card);
        debitCardViewModel = new DebitCardViewModel(this);
    } 
    public void swipe() 
    {
        double amount = isValidAmount();
        double cashback = debitCardViewModel.calculatedCashback(amount); 
        if (cardViewModel.isVaidAmount(amount,card))
        {
           swipe(amount);
           debitCardViewModel.addCashback(card,cashback);
           System.out.println("You get a cashBack :  " + cashback );
           displayBalance();
        }
    } 
    public void withdraw()
    {
        double amount = isValidAmount();
        double calculatedCharge = debitCardViewModel.calculatedCharge(amount);
        if(debitCardViewModel.isVaidAmount(amount,card,calculatedCharge))
        {
            withdraw(amount+calculatedCharge);
            System.out.println("Your  debited  charge   :  " + calculatedCharge );
        }
    }
}
