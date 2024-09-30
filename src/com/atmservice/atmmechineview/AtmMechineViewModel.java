package com.atmservice.atmmechineview;
import java.util.Map;
import com.atmservice.card.CardService;
import com.atmservice.card.DebitCardView;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.filedatabase.Writer;
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
      Map <Long,Card> debitCards = bank.getDepitCard();
      Card debitCard = debitCards.get(cardNumber);
      if(debitCard==null)
      {
         LoginView.alert("This card is Invalid");
         return;
      }
      if(debitCard.getPinNumber()==0)
      {
         setCardPin(debitCard);
      }
      if(debitCard.getPinNumber()==0)
      {
            LoginView.alert("First Generated the pin ");
            return;
      } 
      atmMechineView.getPinNumber(debitCard);
   }
   private void setCardPin(Card debitCard) throws Exception 
   {
       int count =0;
       while(count<3)
      {
         count++;
         if(debitCard.getPinNumber()==0)
         {
            atmMechineView.generatePin(debitCard);
         } 
         if(debitCard.getPinNumber()!=0)
         {
            break;
         }
      }  
   }
   public void generatePin(Card atmCard) 
   {
      if(atmCard.getPinNumber()==0)
      {
         atmMechineView.generatePin(atmCard);
      }
      else
      {
         LoginView.alert("Pin already Generated");
      }
   }
   public void isValidPin(Card card, int pinNumber) 
   {
      if((String.valueOf(pinNumber)).length()==4) 
      {
         card.setPinNumber(pinNumber);
         try
         {
           Writer.modifyCardFile(BankDataLayer.getBankDataLayer().getDepitCard());
         }
         catch (Exception e)
         {
         }
         LoginView.alert("Pin Generated Successfully");
      } 
      else
      {
         LoginView.alert("Pin Exactly 4 digit number");
      } 
   }
   public void validPhoneNumber(long phoneNo, Card card) 
   {
      if(card.getPhoneNumber()!=phoneNo) 
      {
         LoginView.alert("Your phone number is invalid!");
         return;
      }
      atmMechineView.generatePin(card);
   }
   public void isValidPin(int pinNumber, Card card) 
   {
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
         atmMechineView.init(new CardService (new DebitCardView(card)),card);
      }
   }
}
