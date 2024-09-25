package com.atmservice.card;
import com.atmservice.login.LoginView;
import com.atmservice.module.Card;

public class CardViewModel 
{
    private CardView cardView;
    public CardViewModel(CardView cardView) 
    {
         this.cardView = cardView; 
    }
    public boolean isVaidAmount(double amount, Card card) 
    {
        if(card.getBalance()<amount) 
        {
            LoginView.alert("InSufficient Balance"); 
            return false;
        }
        return true;
    }
    public void debitProcess(double amount, Card card) 
    {
        card.setBalance(card.getBalance()-amount);
    }
}
