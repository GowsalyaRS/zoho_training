package com.atmservice.atmmechineview;
import com.atmservice.card.CardService;
import com.atmservice.card.CardView;
import com.atmservice.card.CardViewModel;
import com.atmservice.card.DebitCardView;
import com.atmservice.card.DebitCardViewModel;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.manageaccount.ManageAccountView;
import com.atmservice.module.Card;
import com.atmservice.module.DebitCard;

public class AtmMechineViewModel implements AtmMechineViewModelProcess
{
   private AtmMechineViewProcess atmMechineView;
   BankDataLayer bank = BankDataLayer.getBankDataLayer();
   public void setAtmMechineView(AtmMechineViewProcess atmMechineView) 
   {
      this.atmMechineView = atmMechineView;
   }
   public void checkCardValidation(long cardNumber) 
   {
      Card debitCard = bank.getDepitCard(cardNumber);
      if(debitCard==null)
      {
         LoginView.alert("This card is Invalid");
         return;
      }
      isPinGerated(debitCard);
   }
   private void isPinGerated(Card debitCard) 
   {
      if(debitCard.getPinNumber()==0)
      {
         setCardPin(debitCard);
      }
      else
      {
         isValidPin(debitCard);
      }
   }
   private void setCardPin(Card debitCard) 
   {
       int count =0;
       while(count<3)
      {
         count++;
         if(debitCard.getPinNumber()==0)
         {
            atmMechineView.enterPhoneNumber(debitCard);
         } 
         if(debitCard.getPinNumber()!=0)
         {
            break;
         }
      }  
   }
   public void changePassword(Card card,long phoneNo)  
   {
      int pinNumber = atmMechineView. enterPinNumber();
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
      int pinNumber = atmMechineView. enterPinNumber();
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
         CardViewModel cardViewModel = new CardViewModel(card);
         DebitCardViewModel debitCardViewModel = new DebitCardViewModel(card);
         DebitCardView debitCardView = new DebitCardView(cardViewModel, debitCardViewModel);
         debitCardViewModel.setDebitCardView(new CardView(cardViewModel),debitCardView);
         debitCardViewModel.setTransactionViewModel(ManageAccountView.transactionProcess());
         atmMechineView.grettingMsg(card,new CardService(debitCardViewModel));
      }
   }
}
