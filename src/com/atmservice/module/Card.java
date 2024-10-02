package com.atmservice.module;
public class Card 
{
    private final long cardNumber;
    private String cardName;
    private Account account;
    private int pinNumber;
    public Card(long cardNumber,Account account) 
    {
        this.cardNumber = cardNumber;
        this.account = account;
        cardName = account.getCustomer().getName();
    }
    public Card (long cardNumber,Account account, int pinNumber)
    {
        this.cardNumber = cardNumber;
        this.account = account;
        this.pinNumber = pinNumber;
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
    public long getAccountNo()
    {
       return account.getAccountNumber();
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
    public boolean setPinNumber(int pinNumber,long phoneNo) 
    {
       if(this.account.getCustomer().getPhoneNo()==phoneNo)
       {
          this.pinNumber = pinNumber; 
          return true;
       } 
       return false; 
    }
}
