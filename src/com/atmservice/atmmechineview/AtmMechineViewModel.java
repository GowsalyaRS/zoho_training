package com.atmservice.atmmechineview;
import com.atmservice.card.CardService;
import com.atmservice.card.DebitCardView;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.module.Card;
import com.atmservice.module.DebitCard;

public class AtmMechineViewModel
{
   private AtmMechineView atmMechineView;
   BankDataLayer bank = BankDataLayer.getBankDataLayer();
   AtmMechineViewModel(AtmMechineView atmMechineView) 
   {
      this.atmMechineView = atmMechineView;
   }
   public void checkCardValidation(long cardNumber) throws Exception 
   {
      Card debitCard = bank.getDepitCard(cardNumber);
      if(debitCard==null)
      {
         LoginView.alert("This card is Invalid");
         return;
      }
      if(debitCard.getPinNumber()==0)
      {
         setCardPin(debitCard);
      }
      else
      {
        isValidPin(debitCard);
      }
   }
   private void setCardPin(Card debitCard) throws Exception  
   {
       int count =0;
       while(count<3)
      {
         count++;
         if(debitCard.getPinNumber()==0)
         {
            atmMechineView.changePin(debitCard);
         } 
         if(debitCard.getPinNumber()!=0)
         {
            break;
         }
      }  
   }
   public void changePassword(Card card,long phoneNo)  
   {
      int pinNumber = atmMechineView.generatePin();
      if((String.valueOf(pinNumber)).length()==4) 
      {
         if(card.setPinNumber(pinNumber,phoneNo))
         {
            BankDataLayer.getBankDataLayer().modifyCardFile();
            LoginView.alert("Pin Change Successfully");
         }
         else
         {
            LoginView.alert("Your Phone Number is Invalid ");
         }
      } 
      else
      {
         LoginView.alert("Pin Exactly 4 digit number");
      } 
   }

   public void isValidPin( Card card) 
   {
      int pinNumber = atmMechineView.generatePin();
      if(pinNumber==card.getPinNumber())
      {
         findCard(card);
         return;
      }
      LoginView.alert("Invalid Pin Number ");
   }
   private void findCard(Card card) 
   {
      if(card instanceof DebitCard)
      {
         atmMechineView.init(new CardService(new DebitCardView(card).getInstance()),card);
      }
   }
}
