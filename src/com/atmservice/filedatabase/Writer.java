package com.atmservice.filedatabase;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import com.atmservice.module.Account;
import com.atmservice.module.Card;
import com.atmservice.module.Customer;
import com.atmservice.module.DebitCard;
import com.atmservice.module.Transaction;

public class Writer 
{
   private static String customerFile ;
   private static String accountFile;
   private static String transactionFile;
   private static String cardFile;
   static
   {
    customerFile = "/Users/mdu-incapx2/gowsalya/atmservice/src/com/atmservice/filedatabase/customer.txt";
    accountFile = "/Users/mdu-incapx2/gowsalya/atmservice/src/com/atmservice/filedatabase/account.txt";
    transactionFile = "/Users/mdu-incapx2/gowsalya/atmservice/src/com/atmservice/filedatabase/transaction.txt";
    cardFile = "/Users/mdu-incapx2/gowsalya/atmservice/src/com/atmservice/filedatabase/card.txt";
   }
   public static void printMsg()
    {
        System.out.println("File is not fund");
    }
    public static void writeCustomerFile(Customer customer) throws Exception
    {
        try (PrintWriter file = new PrintWriter( new FileWriter(customerFile,true)))
        {
          file.println(customer.getName() + "," + customer.getPhoneNo());
          file.flush();
        }
        catch(FileNotFoundException e)
        {
            printMsg();
        }
    } 
    public static void writeAccountFile(Account account) throws Exception
    {
        try (PrintWriter file = new PrintWriter(new FileWriter (accountFile,true)))
        {
          file.println(account.getAccountNumber()+ ","+ account.getCustomer().getPhoneNo()+","+account.getBalance());
          file.flush();
        }
        catch(FileNotFoundException e)
        {
            printMsg();
        }
    } 
    public static void writeCardFile(Card card) throws Exception
    {
        try (PrintWriter file = new PrintWriter(new FileWriter (cardFile,true)))
        {
          file.println(card.getCardNumber()+ ","+ card.getAccountNo()+","+ card.getPinNumber());
          file.flush();
        }
        catch(FileNotFoundException e)
        {
            printMsg();
        }
    } 
    public static void writeTransactionFile(Transaction transaction)  throws Exception
    {
        try (PrintWriter file = new PrintWriter(new FileWriter(transactionFile,true)))
        {
          file.println(transaction.getTransactionNo()+"," + transaction.getAccountNo()+"," + transaction.getTransferType() +"," + transaction.getAmount()+"," + transaction.getCurrentBalance()+"," +transaction.getCharge()+ "," + transaction.getDate()+"," + transaction.getTime());
          file.flush();
        }
        catch(FileNotFoundException e)
        {
            printMsg();
        } 
    }
    public static void modifyAccountFile( Map<Long ,Account> accounts) throws Exception 
    {
        clearFileContent(accountFile);
        addContent("Account No,Customer Phone No,balance",accountFile);
        for (Account account : accounts.values())
        {
            writeAccountFile(account);
        }
    }
     public static void clearFileContent(String filePath) throws IOException 
     {
        try (FileWriter writer = new FileWriter(filePath)) 
        {
            writer.write(""); 
        }
    }
    public static void modifyCardFile(Map<Long,Card> cards) throws Exception
    {
        clearFileContent(cardFile);
        addContent("Card No,Account No,Pin",cardFile);
        for (Card card : cards.values())
        {
            writeCardFile(card);
        } 
    }
    public static void addContent(String heading,String path) throws Exception
    {
        try (PrintWriter file = new PrintWriter(new FileWriter (path,true)))
        {
          file.println(heading);
          file.flush();
        }
        catch(FileNotFoundException e)
        {
            printMsg();
        }
    }
}
