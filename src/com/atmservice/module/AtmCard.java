package com.atmservice.module;
public class AtmCard 
{
    private static Long cardNo = 123123234L;
    private final long cardNumber;
    private String cardName;
    private int pinNumber;
    private Account account;
    public AtmCard(Account account) 
    {
        cardNumber = cardNo++;
        this.account    = account;
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
    public void setPinNumber(int pinNumber) 
    {
        this.pinNumber = pinNumber;
    }
    public void deposit(double amount)
    {
        account.deposit(amount);
    }
    public void withdraw (double amount)
    {
        account.withdraw(amount);
    }
    public double showBalance()
    {
        return account.showBalance();
    }
    public void swipe(double amount,double cashBack)
    {
        account.swipe(amount,cashBack);
    }
    public String toString()
    {
        return "CardNumber  : " + cardNumber + " CardName  : " + cardName;
    }
}
