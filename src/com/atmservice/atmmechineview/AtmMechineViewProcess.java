package com.atmservice.atmmechineview;
import com.atmservice.card.CardService;
import com.atmservice.module.Card;

public interface AtmMechineViewProcess 
{  
    int  enterPinNumber();
    void enterCardNumber() ;
    void enterPhoneNumber(Card card);
    void grettingMsg(Card card, CardService cardService);
}