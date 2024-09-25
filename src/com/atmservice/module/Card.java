package com.atmservice.module;
public class Card 
{
    private final long cardNumber;
    private String cardName;
    private int pinNumber;
    private Account account;
    public Card(long cardNumber,Account account) 
    {
        this.cardNumber = cardNumber;
        this.account = account;
        cardName = account.getCustomer().getName();
    }
    public String getCardName()
    {
        return cardName;
    }
    public long getCardNumber() 
    {
        return cardNumber;
    }
    public int getPinNumber() 
    {
        return pinNumber;
    }
    public long getPhoneNumber()
    {
        return account.getCustomer().getPhoneNo();
    }
    public double getBalance()
    {
        return account.getBalance();
    }
    public void setBalance(double balance)
    {
        account.setBalance(balance);
    }
    public void setPinNumber(int pinNumber) 
    {
        this.pinNumber = pinNumber;   
    }
}
