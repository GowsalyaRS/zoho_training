package com.atmservice.manageaccount;
import com.atmservice.module.Account;
import com.atmservice.module.DebitCard;

public interface AccountViewProcess 
{
    void  printDebitCard(DebitCard depitCard);
    void  printAccountDetails(Account account);
}
