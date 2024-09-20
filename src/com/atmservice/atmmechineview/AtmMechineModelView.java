package com.atmservice.atmmechineview;
import java.util.Map;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.module.AtmCard;
public class AtmMechineModelView 
{
    private AtmMechineView atmMechineView;
    AtmMechineModelView(AtmMechineView atmMechineView) 
    {
        this.atmMechineView = atmMechineView;
    }
    public void checkCardValidation(Long cardNumber) 
    {
       BankDataLayer bank = BankDataLayer.getBankDataLayer();
       Map <Long,AtmCard> atmCards = bank.getAtmCard();
       AtmCard atmCard = atmCards.get(cardNumber);
       if(atmCard==null)
       {
          LoginView.alert("This card is Invalid");
          return;
       }
       if(atmCard.getPinNumber()==0)
       {
          atmMechineView.generatePin(atmCard);
       }
       atmMechineView.getPinNumber(atmCard);
    }
    public void generatePin(AtmCard atmCard) 
    {
        if(atmCard.getPinNumber()==0)
        {
            atmMechineView.generatePin(atmCard);
        }
        else
        {
           LoginView.alert("Atm pin already Generated");
        }
    }
    public void isValidPin(AtmCard atmCard, int pinNumber) 
    {
         if((""+pinNumber).length()==4) 
         {
            atmCard.setPinNumber(pinNumber);
            LoginView.alert("Pin Generated Successfully");
            return ;
         } 
            LoginView.alert("Pin Exactly 4 digit set");
    }
    public void validPhoneNumber(long phoneNo, AtmCard atmCard) 
    {
        if(atmCard.getPhoneNumber()!=phoneNo) 
        {
           LoginView.alert("Your not change Atm pin ");
           return;
        }
        atmMechineView.generatePin(atmCard);
    }
    public void isValidPin(int pinNumber, AtmCard atmCard) 
    {
        if(pinNumber==atmCard.getPinNumber())
        {
           atmMechineView.init(atmCard);
           return;
        }
         LoginView.alert("Invalid Pin Number ");
    }
   public void isDeposite(double amount, AtmCard atmCard) 
   {
      if(!isValidAmount(amount))
      {
         LoginView.alert("Enter the positive Number ");
         return;
      }
      atmMechineView.deposit(atmCard,amount);
   }
   public void isWithdraw(double amount, AtmCard atmCard) 
   {
      if(!isValidAmount(amount))
      {
         LoginView.alert("Enter the positive Number ");
         return;
      }
      if(amount%5!=0)
      {
         LoginView.alert("Amount must be a USD 5 ");
         return;
      }
      BankDataLayer bank = BankDataLayer.getInstance();
      double withdrawCharge = (amount<100)? (amount* bank.getBank().getMininumCharge()): (amount*bank.getBank().getMaximunCharge()); // caluculate the withdraw charge
      amount+=withdrawCharge;
      if(atmCard.showBalance()<amount)
      {
         LoginView.alert("Balance is Low");   
         return;
      }
      atmMechineView.withdraw(amount,atmCard,withdrawCharge);
   }
    private boolean isValidAmount(double amount)
    {
         if(amount<0)
         {
             return false;
         }
         return true;
    }
   public void isSwipe(double amount, AtmCard atmCard) 
   {
      if(atmCard.showBalance()<amount)
      {
         LoginView.alert("Balance is Low"); 
         return;
      }
      double cashBack= amount * BankDataLayer.getInstance().getBank().getCashBackPercentage();
      atmMechineView.swipe(amount,atmCard,cashBack);
   }
}
