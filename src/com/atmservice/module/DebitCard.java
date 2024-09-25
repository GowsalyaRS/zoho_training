package com.atmservice.module;
public class DebitCard extends Card
{
    private static long cardNo = 123123234L;
    public DebitCard(Account account) 
    {
        super(cardNo++,account);
    }
}
