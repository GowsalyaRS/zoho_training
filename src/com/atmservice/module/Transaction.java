package com.atmservice.module;
import java.time.LocalDate; 
import java.time.LocalTime; 
import java.sql.Time;
public class Transaction 
{
    private static long transactionCount = 1020340l;
    private long transactionNo;
    private long accountNo;
    private TransferType transferType;
    private double amount;
    private double currentBalance;
    private LocalDate date;
    private Time time;
    private double charge;
    public Transaction(long accountNo, TransferType transferType,double amount,double currentBalance)
    {
        transactionNo = ++transactionCount;
        this.accountNo = accountNo;
        this.transferType = transferType;
        this.amount=amount;
        date = LocalDate.now();
        time = Time .valueOf(LocalTime.now());
        this.currentBalance = currentBalance;
    }
    public Transaction(long accountNo, TransferType transferType, double amount, double balance, double charge) {
        this(accountNo, transferType, amount, balance);
        this.charge = charge;
    }
    public Transaction(long transactionNo,long accountNo, TransferType transferType, double amount, double balance, double charge,LocalDate date ,Time time) 
    {
        this(accountNo, transferType, amount, balance,charge);
        this.transactionNo =transactionNo;
        this.date = date;
        this.time = time;
    }
    public long getTransactionNo() {
        return transactionNo;
    }
    public long getAccountNo() {
        return accountNo;
    }
    public double getAmount() {
        return amount;
    }
    public TransferType getTransferType() {
        return transferType;
    }
    public LocalDate getDate() {
        return date;
    }
    public Time getTime() {
        return time;
    }
    public double getCharge()
    {
        return charge;
    }
    public double getCurrentBalance()
    {
        return currentBalance;
    }
    public void setCharge(double charge)
    {
       this.charge = charge;
    }
    public void setTranactionNumber(long transactionCount)
    {
       this.transactionCount = transactionCount;
    }
    public String toString()
    {
        return ( " "+ transactionNo + "\t"   +   date + "\t"  +     time    +"\t"  +      amount+ "\t\t "  +   charge    +"\t\t "  + currentBalance +     "\t\t"  + transferType );
    }
}
