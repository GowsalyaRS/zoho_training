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
         if((pinNumber%1000)<=999) 
         {
            atmCard.setPinNumber(pinNumber);
            LoginView.alert("Pin Generated Successfully");
            return ;
         } 
         else
         {
            LoginView.alert("Pin Exactly 4 digit set");
         }
    }
    public void validPhoneNumber(Long phoneNo, AtmCard atmCard) 
    {
        if(atmCard.getPhoneNumber()==phoneNo) 
        {
           atmMechineView.generatePin(atmCard);
           return;
        }
        LoginView.alert("Your not change Atm pin ");
    }
    public void isValidPin(int pinNumber, AtmCard atmCard) 
    {
        if(pinNumber==atmCard.getPinNumber())
        {
           atmMechineView.init(atmCard);
        }
        else
        {
            LoginView.alert("Invalid Pin Number ");
        }
    }
}
