package com.atmservice.module;
public class XyzBankAccount  extends Account 
{
    private static long accountNo= 23418920101L;
    public XyzBankAccount(Customer customer,double balance) 
    {
        super(customer,accountNo+=1,balance);
    }
    private double calculateCharges(double amount) 
    {
        return amount <= 100 ? amount * 0.02 : amount * 0.04;
    }
    private double calculateCashBack(double amount)
    {
        return amount*0.01;
    }
    @Override
    public String withdraw(double amount)
    {
        if(amount % 5 != 0) {
            return ("Amount must be a multiple of USD 5.");
        }
        if(getBalance()<100) {
            return ("Amount must be a above USD 100");
        }
        double chargeOfAmount = calculateCharges(amount);
        amount+=chargeOfAmount;
        if(getBalance()>=amount)
        {
            setBalance(getBalance()-amount);
            return "Withdraw successfully.....! "  + (amount-chargeOfAmount);
        }
        return "Amount is low....";
    } 
    @Override
    public String swipe(double amount) 
    { 
        if(getBalance()>=amount) 
        {
            double cashBack = calculateCashBack(amount);
            setBalance((getBalance()-amount)+cashBack);
            return "Swipe the process you get a cashback : 1% =  " +   cashBack;
        }
        return "Amount is low....";
    }
}

