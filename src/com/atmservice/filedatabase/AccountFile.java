package com.atmservice.filedatabase;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.module.Account;
import com.atmservice.module.Customer;

public class AccountFile  implements AccountFileProcess 
{
    private static String accountFile;
    static
    {
        accountFile = "src/com/atmservice/filedatabase/account.txt";
    }
    public  List<Account> readAccountFile() throws Exception {
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
           LoginView.alert("File Not Found");
        }
        return account;
    }
    public  void writeAccountFile(Account account) throws Exception
    {
        try (PrintWriter file = new PrintWriter(new FileWriter (accountFile,true)))
        {
          file.println(account.getAccountNumber()+ ","+ account.getCustomer().getPhoneNo()+","+account.getBalance());
          file.flush();
        }
        catch(FileNotFoundException e)
        {
            LoginView.alert("File Not Found");
        }
    } 
    public void modifyAccountFile( Map<Long ,Account> accounts) throws Exception 
    {
        clearFileContent(accountFile); 
        addContent("Account No,Customer Phone No,balance",accountFile);
        for (Account account : accounts.values())
        {
            writeAccountFile(account);
        }
    }
} 
