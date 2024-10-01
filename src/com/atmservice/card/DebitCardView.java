package com.atmservice.card;
import com.atmservice.module.Card;
import com.atmservice.module.Transaction;
import com.atmservice.module.TransferType;
import com.atmservice.transaction.TransactionViewModel;

public class DebitCardView  extends CardView
{
    private DebitCardViewModel debitCardViewModel;
    private TransactionViewModel transactionViewModel;
    public DebitCardView(Card card)
    {
        super(card);
        debitCardViewModel = new DebitCardViewModel(this);
        transactionViewModel = new TransactionViewModel();
    } 
    public void swipe() 
    {
        double amount = isValidAmount();
        double cashback = debitCardViewModel.calculatedCashback(amount); 
        if (cardViewModel.isVaidAmount(amount,card))
        {
           swipe(amount);
           debitCardViewModel.addCashback(card,cashback);
           Transaction transaction = new Transaction(card.getAccountNo(),TransferType.SWIPE, amount, card.getBalance(),cashback);
           transactionViewModel.setHistoryData(transaction);
           System.out.println("You get a cashBack :  " + cashback );
           displayBalance();
        }
    } 
    public void withdraw()
    {
        double amount = isValidAmount();
        double calculatedCharge = debitCardViewModel.calculatedCharge(amount);
        if(debitCardViewModel.isVaidAmount(amount,card))
        {
            withdraw(amount+calculatedCharge);
            Transaction transaction = new Transaction(card.getAccountNo(),TransferType.WITHDRAW, amount, card.getBalance(),calculatedCharge*-1);
            transactionViewModel.setHistoryData(transaction);
            System.out.println("Your  debited  charge   :  " + calculatedCharge );
        }
    }
}
