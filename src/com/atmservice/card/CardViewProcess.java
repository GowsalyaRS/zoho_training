package com.atmservice.card;

public interface CardViewProcess 
{
    void swipeDetails(double amount);
    void depositeView(double amount);
    void withdrawDetails(double amount); 
    double isEnterValidAmount();
}
