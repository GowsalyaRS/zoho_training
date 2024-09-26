package com.atmservice.card;
import com.atmservice.service.CardProcess;

public class CardService 
{
    private CardProcess cardProcess;
    public CardService(CardProcess cardProcess)
    {
        this.cardProcess = cardProcess;
    }
    public double showBalance()
    {
       return  cardProcess.showBalance();
    }
    public void withdraw()
    {
        cardProcess.withdraw();
    }
    public void deposit()
    {
        cardProcess.deposit();
    }
    public void swipe()
    {
        cardProcess.swipe();
    }
}
