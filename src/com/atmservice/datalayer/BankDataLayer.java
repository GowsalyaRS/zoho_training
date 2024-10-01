package com.atmservice.datalayer;
import com.atmservice.filedatabase.Writer;
import com.atmservice.module.Account;
import com.atmservice.module.Bank;
import com.atmservice.module.Card;
import com.atmservice.module.Customer;
import com.atmservice.module.DebitCard;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import com.atmservice.module.Transaction;
import java.util.ArrayList; 

public class BankDataLayer 
{
    private Bank bank;
    private static BankDataLayer bankDataLayer;
    private Map <Long,Card> depitCards = new LinkedHashMap(); 
    private Map <Long,Account> accounts = new LinkedHashMap();
    private Map <Account,DebitCard> accountCards= new LinkedHashMap();
    private Map <Long,Customer> customers= new LinkedHashMap<>();
    private Map <Account,ArrayList<Transaction>> transactionHistory = new LinkedHashMap();
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
    public Map<Long,Card> getDepitCard() {
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
    public Map <Account,ArrayList<Transaction>> getAccountHistory()
    {
        return transactionHistory;
    }
    public Bank getBank()
    {
        return bank;
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
    public void setTransactionHostory(Account account,Transaction transaction)
    {
        ArrayList <Transaction> transactions = transactionHistory.get(account);
        double balance = transaction.getCurrentBalance();
        if(account!=null)
        {
           account.setBalance(balance);
        }
        if(transactions==null)
        {
            transactions = new ArrayList();
            transactionHistory.put(account,transactions);
        }
        transactions.add(transaction);
        try
        {
           Writer.modifyAccountFile(getAccount());
        }
        catch(Exception e)
        {
        }
    }
    public void setCustomer(List<Customer> customerFile) 
    {
        if(customerFile.size()>0)
        {
            for(Customer cus : customerFile)
            {
                setCustomer(cus);
            }
        }
    }
    public void setAccount(List<Account> accountFile) 
    {
       if(accountFile.size()>0)  
       {
            long accountNo =0;
            Account accounts =null;
            for(Account account : accountFile)
            { 
                accounts = account;
                setAccountDetails(account);
                accountNo = account.getAccountNumber();
            }
            accounts.setAccountNumber(accountNo);
       }
    }
    public void setTransaction(List<Transaction> transactionFile) 
    {
        if(transactionFile.size()>0)
        {
            long transactionNo =0;
            Transaction  transactions = null;
            for(Transaction transaction : transactionFile)
            {
                setTransactionHostory(accounts.get(transaction.getAccountNo()),transaction);
                transactions = transaction;
                transactionNo = transactions.getTransactionNo();
            }
            transactions.setTranactionNumber(transactionNo);
        }
    }
    public void setDebitCard(List<Card> cardFile) 
    {
        if(cardFile.size()>0)  
        {
            long cardNo =0;
            DebitCard card = null;
            for(Card cards: cardFile)
            {
                card = (DebitCard)cards;
                setDebitCard(card);
                cardNo = card.getCardNumber();
            }
            card.setCardNumber(cardNo);
        }
    }
}
