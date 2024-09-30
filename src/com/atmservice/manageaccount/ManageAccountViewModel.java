package com.atmservice.manageaccount;
import java.util.Map;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.filedatabase.Writer;
import com.atmservice.login.LoginView;
import com.atmservice.module.Account;
import com.atmservice.module.Customer;
import com.atmservice.module.DebitCard;

public class ManageAccountViewModel
{
    private ManageAccountView accountView;
    private BankDataLayer bank;
    private  Map<Long,Account> accounts;
    private  Map <Account,DebitCard> acountDebitCard;
    public ManageAccountViewModel(ManageAccountView accountView) 
    {
       this.accountView = accountView; 
       bank = BankDataLayer.getBankDataLayer();
    }
    public ManageAccountViewModel()
    {
    }
    public void validAmount(Customer customer,double amount) throws Exception 
    {
        if(amount<100)
        {
            LoginView.alert("amount is Invalid above USD 100 ");
            return;
        }
        Account account = new Account(customer, amount);
        Writer.writeCustomerFile(customer);
        Writer.writeAccountFile(account);
        bank.setCustomer(customer);
        bank.setAccountDetails(account);
        accountView.detailsAccount(account);
    }
    public Account validAccount(long accountNumber) 
    {
        accounts = bank.getAccount(); 
        Account account = accounts.get(accountNumber);   
        if(account==null)
        {
            return null;
        }
        return account;
    }
    public void addAccountDetails(Account account) throws Exception
    {
        acountDebitCard = bank.getAccountCard();
        if (acountDebitCard.get(account)==null)
        {
            DebitCard depitCard = new DebitCard(account);
            bank.setDebitCard(depitCard);
            bank.setAccountDebitCard(account, depitCard);
            accountView.provideDebitCard(depitCard);
            Writer.writeCardFile(depitCard);
        }
        else
        {
            LoginView.alert("Already allocate Debit card");
        }
    }
}
