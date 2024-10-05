package com.atmservice.manageaccount;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.filedatabase.AccountFile;
import com.atmservice.filedatabase.CustomerFile;
import com.atmservice.login.LoginView;
import com.atmservice.module.Account;
import com.atmservice.module.Customer;
import com.atmservice.module.DebitCard;

public class ManageAccountViewModel implements AccountViewModelProcess
{
    private AccountViewProcess accountView;
    private static  BankDataLayer bank;
    static
    {
        bank = BankDataLayer.getBankDataLayer();
    }
    public void setAccountView(AccountViewProcess accountView) 
    {
        this.accountView = accountView;
    }
    public boolean validAmount(double amount)
    {
        if(amount<100)
        {
            LoginView.alert("amount is Invalid above USD 100 ");
            return false;
        }
        return true;
    }
    public void createAccount(Customer customer,double amount) 
    {
        Account account = new Account(customer, amount);
        bank.setCustomerFile(new CustomerFile());
        bank.setAccountFile(new AccountFile());
        bank.writeAccountFile(account);
        accountView.printAccountDetails(account);  
    }
    public Account validAccount(long accountNumber) 
    {
        Account account = bank.getAccount().get(accountNumber);
        return account;
    }
    public void provideDebitCard(Account account) 
    {
        if (bank.getAccountCard().get(account)==null)
        {
            DebitCard depitCard = new DebitCard(account);
            bank.setDebitCard(depitCard);
            bank.setAccountDebitCard(account, depitCard);
            accountView.printDebitCard(depitCard);
        }
        else
        {
            LoginView.alert("Already allocate Debit card");
        }
    }
}
