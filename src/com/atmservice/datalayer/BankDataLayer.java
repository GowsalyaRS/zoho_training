package com.atmservice.datalayer;
import com.atmservice.module.Account;
import com.atmservice.module.AtmCard;
import com.atmservice.module.Bank;
import com.atmservice.module.Customer;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class BankDataLayer 
{
    private Bank bank;
    private static BankDataLayer bankDataLayer;
    private Map <Long,AtmCard> atmCards = new HashMap(); 
    private Map <Long,Account> accounts = new HashMap();
    private Map <Account,AtmCard> accountAtmCards= new HashMap();
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
    public Map<Long, AtmCard> getAtmCard() {
        return atmCards;
    }
    public Map<Long, Account> getAccount() {
        return accounts;
    }
    public Map<Long, Customer> getCustomer() {
        return customers;
    }
    public Map <Account,AtmCard> getAccountAtmCard()
    {
        return accountAtmCards;
    }
    public void setAccountAtmCard(Account account,AtmCard atmCard)
    {
        accountAtmCards.put(account,atmCard);
    }
    public void setCustomer(Customer customer)
    {
       customers.put(customer.getPhoneNo(),customer);
    }
    public void setAccountDetails(Account account)
    {
        accounts.put(account.getAccountNumber(),account);
    }
    public void setAtmCard(AtmCard atmCard)
    {
       atmCards.put(atmCard.getCardNumber(),atmCard);
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
