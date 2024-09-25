package com.atmservice.datalayer;
import com.atmservice.module.Account;
import com.atmservice.module.Bank;
import com.atmservice.module.Customer;
import com.atmservice.module.DebitCard;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class BankDataLayer 
{
    private Bank bank;
    private static BankDataLayer bankDataLayer;
    private Map <Long,DebitCard> depitCards = new HashMap(); 
    private Map <Long,Account> accounts = new HashMap();
    private Map <Account,DebitCard> accountCards= new HashMap();
    private Map <Long,Customer> customers= new LinkedHashMap<>();
    private BankDataLayer()
    {   
    }
    public static BankDataLayer getInstance()
    {
        if(bankDataLayer==null)
        {
            bankDataLayer = new BankDataLayer();
        }
        return bankDataLayer;
    }
    public static BankDataLayer getBankDataLayer() {
        return bankDataLayer;
    }
    public Map<Long,DebitCard> getDepitCard() {
        return depitCards;
    }
    public Map<Long, Account> getAccount() {
        return accounts;
    }
    public Map<Long, Customer> getCustomer() {
        return customers;
    }
    public Map <Account,DebitCard> getAccountCard()
    {
        return accountCards;
    }
    public void setAccountDebitCard(Account account,DebitCard depitCard)
    {
        accountCards.put(account,depitCard);
    }
    public void setCustomer(Customer customer)
    {
       customers.put(customer.getPhoneNo(),customer);
    }
    public void setAccountDetails(Account account)
    {
        accounts.put(account.getAccountNumber(),account);
    }
    public void setDebitCard(DebitCard debitCard)
    {
       depitCards.put(debitCard.getCardNumber(),debitCard);
    }
    public  void setBankProperty(Bank bank)
    {
       this.bank = bank;
    }
    public Bank getBank()
    {
        return bank;
    }
}
