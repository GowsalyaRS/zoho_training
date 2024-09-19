package com.atmservice.manageaccount;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.module.Account;
import com.atmservice.module.AtmCard;
import com.atmservice.module.Customer;
public class ManageAccountModelView 
{
    private ManageAccountView accountView;
    private BankDataLayer bank;
    public ManageAccountModelView(ManageAccountView accountView) 
    {
       this.accountView = accountView; 
       bank = BankDataLayer.getBankDataLayer();
    }
    public void validCustomer(String name, Long phoneNo) 
    {
        
        Pattern ptrn = Pattern.compile("^[A-Za-zÀ-ÖØ-ÿ]+$");
        Matcher  matcher  = ptrn.matcher(name);
        if(!matcher.matches())
        {
            LoginView.alert("User Name is Invalid");
            return;
        }
        ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
        matcher = ptrn.matcher(""+phoneNo);
        if(!matcher.matches())
        {
            LoginView.alert("User Phone no is Invalid");
            return;
        }
        Map <Long,Customer>  customers = bank.getCustomer();
        Customer customer =customers.get(phoneNo);
        if(customer!=null)
        {
            LoginView.alert("Your Phone Number already have a account so another phone number enter");
            return;
        }
        customer = new Customer(name, phoneNo);
        accountView.createAccount(customer);
    }
    public void validAmount(Customer customer,double amount) 
    {
        if(amount<100)
        {
            LoginView.alert("amount is Invalid above USD 100 ");
            return;
        }
        accountView.createAccount(customer,amount);
    }
    public void validAccount(Long accountNumber) 
    {
        Map <Long,Account> accounts = bank.getAccount(); 
        Account account = accounts.get(accountNumber);   
        if(account==null)
        {
            LoginView.alert("Account Number is Invalid..!");
            return;
        }
        Map <Account,AtmCard> acountAtmcard = bank.getAccountAtmCard();
        if (acountAtmcard.get(account)==null)
        {
            AtmCard atm = new AtmCard(account);
            accountView.provideATMCard(atm,account);
        }
        else
        {
            LoginView.alert("Already allowcate ATM card");
        }
    }
}
