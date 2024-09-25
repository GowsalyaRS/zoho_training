package com.atmservice.card;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.module.Card;

public class DebitCardViewModel 
{
    private DebitCardView debitCardView;
    public DebitCardViewModel(DebitCardView debitCardView) 
    {
        this.debitCardView = debitCardView;
    }
    public double calculatedCharge(double amount) 
    {
        double charge =0;
        if(amount<100)
        {
           charge =  BankDataLayer.getInstance().getBank().getMininumCharge();
        }
        else
        {
           charge = BankDataLayer.getInstance().getBank().getMaximunCharge();
        }
        charge*=amount;  
        return  Double.parseDouble(String.format( "%.2f", charge));
    }
    public double calculatedCashback(double amount) 
    {
         amount*= BankDataLayer.getBankDataLayer().getBank().getCashBackPercentage();  
         return  Double.parseDouble(String.format( "%.2f", amount));  
    }
    public void addCashback(Card card, double cashback) 
    {
        card.setBalance(card.getBalance()+cashback); 
    }
    public boolean isVaidAmount(double amount, Card card,double calculatedCharge) 
    {
        if(amount%5!=0) 
        {
            return false;
        }
        if(card.getBalance()<amount) 
        {
            LoginView.alert("InSufficient Balance"); 
            return false;
        }
        return true;
    }
}
