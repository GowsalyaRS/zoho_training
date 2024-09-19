package com.atmservice.module;
public class AtmCard 
{
    private static Long cardNo = 123123234L;
    private long cardNumber;
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
    public Long getPhoneNumber()
    {
        return account.getCustomer().getPhoneNo();
    }
    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }
    public void deposit(double amount)
    {
         account.deposit(amount);
    }
    public String withdraw (double amount)
    {
        return account.withdraw(amount);
    }
    public double showBalance()
    {
        return account.showBalance();
    }
    public String swipe(double amount)
    {
        return account.swipe(amount);
    }
    public String toString()
    {
        return "CardNumber  : " + cardNumber + " CardName  : " + cardName;
    }
}
