package com.atmservice.datalayer;
import com.atmservice.filedatabase.Reader;
import com.atmservice.filedatabase.Writer;
import com.atmservice.module.Account;
import com.atmservice.module.Bank;
import com.atmservice.module.Card;
import com.atmservice.module.Customer;
import com.atmservice.module.DebitCard;
import java.util.Map;
import java.util.List;
import com.atmservice.module.Transaction;
import java.util.ArrayList; 
import java.util.HashMap;

public class BankDataLayer 
{
    private Bank bank;
    private static BankDataLayer bankDataLayer;
    private Map <Long,Card> depitCards = new HashMap(); 
    private Map <Long,Account> accounts = new HashMap();
    private Map <Account,DebitCard> accountCards= new HashMap();
    private Map <Long,Customer> customers= new HashMap<>();
    private Map <Account,ArrayList<Transaction>> transactionHistory = new HashMap();
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
        try
        {
          Writer.writeCardFile(depitCard);
        }
        catch(Exception e)
        {
        }
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
    public void setTransaction(Transaction transaction)
    {
       Account account =  accounts.get(transaction.getAccountNo());
       if(transactionHistory.get(account)==null)
       {
          ArrayList <Transaction> trans =new ArrayList<>();
          trans.add(transaction);
          transactionHistory.put(account,trans);
       }
       else
       {
          transactionHistory.get(account).add(transaction);
       }
    }
    public  void setBankProperty(Bank bank)
    {
       this.bank = bank;
    }
    public  void setPerperty() throws Exception 
    {
        BankDataLayer bank = BankDataLayer.getBankDataLayer();
        bank.setCustomer(Reader.readCustomerFile());  
        bank.setAccount(Reader.readAccountFile()); 
        bank.setDebitCard(Reader.readCardFile());
        bank.setTransaction(Reader.readTransactionFile());   
    }
    public void setTransactionHistory(Account account,Transaction transaction)
    {
        ArrayList <Transaction> transactions = transactionHistory.get(account);
        if(transactions==null)
        {
            transactions = new ArrayList();
            transactionHistory.put(account,transactions);
        }
        transactions.add(transaction);
        try
        {
           Writer.writeTransactionFile(transaction);
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
            long accountNo =Account.getAccountNo();
            for(Account account : accountFile)
            { 
                setAccountDetails(account);
                accountNo+=1;
            }
            Account.setAccountNo(accountNo);
        }
    }
    public void setTransaction(List<Transaction> transactionFile) 
    {
        if(transactionFile.size()>0)
        {
            long transactionNo =Transaction.getTransactionCount();
            for(Transaction transaction : transactionFile)
            {
                setTransaction(transaction);
                transactionNo+=1;
            }
            Transaction.setTransactionCount(transactionNo);
        }
    }
    public void setDebitCard(List<Card> cardFile) 
    {
        if(cardFile.size()>0)  
        {
            long cardNo = DebitCard.getCardNo();
            DebitCard card = null;
            for(Card cards: cardFile)
            {
                card = (DebitCard)cards;
                setDebitCard(card);
                cardNo+=1;
            }
            DebitCard.setCardNo(cardNo);
        }
    }
    public void writeAccountFile(Account account) 
    {
        setCustomer(account.getCustomer());
        setAccountDetails(account);   
        try
        {
            Writer.writeCustomerFile(account.getCustomer());
            Writer.writeAccountFile(account);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
    }
    public Card getDepitCard(long cardNumber) 
    {
        return depitCards.get(cardNumber); 
    }
    public void modifyCardFile() 
    {
        try
        {
          Writer.modifyCardFile(BankDataLayer.getBankDataLayer().getDepitCard());
        }
        catch (Exception e)
        {
            Writer.printMsg();
        }
    }
    public void createAccount(Account account) 
    {
        try
        {
           Writer.writeCustomerFile(account.getCustomer());
           Writer.writeAccountFile(account);
        }
        catch(Exception e)
        {
           Writer.printMsg();
        }
    }
}
