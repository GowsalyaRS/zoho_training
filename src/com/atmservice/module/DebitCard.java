package com.atmservice.module;
public class DebitCard extends Card
{
    private static long cardNo = 123123233L;
    public DebitCard(Account account) 
    {
        super(++cardNo,account);
    }
    public DebitCard(long cardNumber,Account account, int pinNumber)
    {
        super(cardNumber,account,pinNumber);
    }
    public void setCardNumber(long cardNo)
    {
       this.cardNo = cardNo;
    }
}
