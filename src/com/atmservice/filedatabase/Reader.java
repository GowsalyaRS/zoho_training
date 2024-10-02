package com.atmservice.filedatabase;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.module.Account;
import com.atmservice.module.Card;
import com.atmservice.module.Customer;
import com.atmservice.module.DebitCard;
import com.atmservice.module.Transaction;
import com.atmservice.module.TransferType;

public class Reader {
    private static String customerFile;
    private static String accountFile;
    private static String transactionFile;
    private static String cardFile;
    static 
    {
        customerFile    = "src/com/atmservice/filedatabase/customer.txt";
        accountFile     = "src/com/atmservice/filedatabase/account.txt";
        transactionFile = "src/com/atmservice/filedatabase/transaction.txt";
        cardFile        = "src/com/atmservice/filedatabase/card.txt";
    }
    public static List<Customer> readCustomerFile() throws Exception {
        List<Customer> customers = new ArrayList();
        try (BufferedReader s = new BufferedReader(new FileReader(customerFile))) 
        {
            String n = s.readLine();
            n = s.readLine();
            while (n!= null && !n.isEmpty() && n!="\\s" ) 
            {
                String[] arr = n.split(",");
                String name = arr[0];
                long phoneNo = Long.parseLong(arr[1]);
                customers.add(new Customer(name, phoneNo));
                n = s.readLine();
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
            Writer.printMsg();
        }
        return customers;
    }

    public static List<Account> readAccountFile() throws Exception {
        List<Account> account = new ArrayList();
        Map <Long,Customer> customers =  BankDataLayer.getBankDataLayer().getCustomer();
        try (BufferedReader s = new BufferedReader(new FileReader(accountFile))) {
            s.readLine();
            String n = s.readLine();
            while (n!= null && !n.isEmpty() && n!="\\s") 
            {
                String[] arr = n.split(",");
                long accountNo = Long.parseLong(arr[0]);
                long phoneNo = Long.parseLong(arr[1]);
                Customer customer = customers.get(phoneNo);
                double balance = Double.parseDouble(arr[2]);
                account.add(new Account(accountNo, customer, balance));
                n = s.readLine();
            }
        } 
        catch (FileNotFoundException e)
        {
            Writer.printMsg();
        }
        return account;
    }
    public static List<Card> readCardFile() throws Exception 
    {
        List<Card> cards = new ArrayList();
        Map <Long,Account> accounts = BankDataLayer.getBankDataLayer().getAccount();
        try (BufferedReader s = new BufferedReader(new FileReader(cardFile))) 
        {
            String n = s.readLine();
            n = s.readLine();
            while (n!= null && !n.isEmpty() && n!="\\s" ) 
            {
                String[] arr = n.split(",");
                long cardNumber = Long.parseLong(arr[0]);
                long accountNo = Long.parseLong(arr[1]);
                Account account = accounts.get(accountNo);
                int pin = Integer.parseInt(arr[2]);
                cards.add(new DebitCard(cardNumber,account,pin));
                n = s.readLine();
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            Writer.printMsg();
        }
        return cards;
    }
    public static List<Transaction> readTransactionFile() throws Exception
    {
        List<Transaction> transactions = new ArrayList();
        try (BufferedReader s = new BufferedReader(new FileReader(transactionFile))) 
        {
            s.readLine();
            String n = s.readLine();
            while (n!= null && !n.isEmpty() && n!="\\s") {
                String[] arr = n.split(",");
                long transactionNo = Long.parseLong(arr[0]);
                long accountNo = Long.parseLong(arr[1]);
                TransferType transferType = TransferType.valueOf(arr[2]);
                double amount = Double.parseDouble(arr[3]);
                double currentBalance = Double.parseDouble(arr[4]);
                double charge = Double.parseDouble(arr[5]);
                LocalDate date = LocalDate.parse(arr[6]);
                Time time = Time.valueOf(arr[7]);
                transactions.add(new Transaction(transactionNo, accountNo, transferType, amount, currentBalance, charge,
                        date, time));
                n = s.readLine();
            }
        } 
        catch (FileNotFoundException e) 
        {
            Writer.printMsg();
        }
        return transactions;
    }
    
}
