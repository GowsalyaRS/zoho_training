package com.atmservice.manageaccount;
import java.util.Map;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.module.Account;
import com.atmservice.module.Customer;
import com.atmservice.module.DebitCard;

public class ManageAccountViewModel
{
    private ManageAccountView accountView;
    private BankDataLayer bank;
    public ManageAccountViewModel(ManageAccountView accountView) 
    {
       this.accountView = accountView; 
       bank = BankDataLayer.getBankDataLayer();
    }
   
    public void validAmount(Customer customer,double amount) 
    {
        if(amount<100)
        {
            LoginView.alert("amount is Invalid above USD 100 ");
            return;
        }
        Account account = new Account(customer, amount);
        BankDataLayer bank =  BankDataLayer.getBankDataLayer();
        bank.setCustomer(customer);
        bank.setAccountDetails(account);
        accountView.detailsAccount(account);
    }
    public void validAccount(long accountNumber) 
    {
        Map<Long,Account> accounts = bank.getAccount(); 
        Account account = accounts.get(accountNumber);   
        if(account==null)
        {
            LoginView.alert("Account Number is Invalid..!");
            return;
        }
        Map <Account,DebitCard> acountDebitCard = bank.getAccountCard();
        if (acountDebitCard.get(account)==null)
        {
            DebitCard depitCard = new DebitCard(account);
            bank.setDebitCard(depitCard);
            bank.setAccountDebitCard(account, depitCard);
            accountView.provideDebitCard(depitCard);
        }
        else
        {
            LoginView.alert("Already allocate ATM card");
        }
    }
}
