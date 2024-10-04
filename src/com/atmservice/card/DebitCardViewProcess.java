package com.atmservice.card;

public interface DebitCardViewProcess 
{
    double isEnterValidAmount();
    void swipeDetails(double cashback);
    void withdrawDetails(double calculatedCharge);
}
