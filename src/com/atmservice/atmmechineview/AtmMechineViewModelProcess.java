package com.atmservice.atmmechineview;
import com.atmservice.module.Card;

public interface AtmMechineViewModelProcess 
{
    void checkCardValidation(long cardNumber) ;
    void changePassword(Card card,long phoneNo);
}
