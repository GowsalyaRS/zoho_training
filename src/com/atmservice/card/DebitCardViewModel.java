package com.atmservice.card;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.module.Card;
import com.atmservice.module.Transaction;
import com.atmservice.module.TransferType;

public class DebitCardViewModel extends CardViewModel implements DebitCardViewModelProcess
{
    private DebitCardViewProcess debitCardView;
    public DebitCardViewModel(Card card)
    {
        super(card);
        this.card = card;
    }
    public void setDebitCardView(CardViewProcess cardView, DebitCardViewProcess debitCardView) 
    {
        super.setCardView(cardView);
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
    public void addCashback(double cashback) 
    {
        card.setBalance(card.getBalance()+cashback); 
    }
    public boolean isVaidAmount(double amount) 
    {
        if(amount%5!=0) 
        {
            LoginView.alert("Amount must be multiple of USD 5");
            return false;
        }
        if(card.getBalance()<amount) 
        {
            LoginView.alert("InSufficient Balance"); 
            return false;
        }
        return true;
    }
    public void swipe() 
    {
        double amount = debitCardView.isEnterValidAmount();
        double cashback = calculatedCashback(amount); 
        if (isVaidAmounts(amount))
        {
           swipe(amount);
           addCashback(cashback);
           Transaction transaction = new Transaction(card.getAccountNo(),TransferType.SWIPE, amount, card.getBalance(),cashback);
           transactionViewModel.setHistoryData(transaction);
           debitCardView.swipeDetails(cashback);
        }
    } 
    public void withdraw()
    {
        double amount = debitCardView.isEnterValidAmount();
        double calculatedCharge =calculatedCharge(amount);
        if(isVaidAmount(amount))
        {
            withdraw(amount+calculatedCharge);
            Transaction transaction = new Transaction(card.getAccountNo(),TransferType.WITHDRAW, amount, card.getBalance(),calculatedCharge*-1);
            transactionViewModel.setHistoryData(transaction);
            debitCardView.withdrawDetails(calculatedCharge);
        }
    }
}
