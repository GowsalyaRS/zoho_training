package com.atmservice.filedatabase;
import java.io.FileNotFoundException;
import com.atmservice.login.LoginView;
import com.atmservice.module.Transaction;
import com.atmservice.module.TransferType;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.sql.Time;
import java.time.LocalDate;
import java.io.PrintWriter;
import java.io.FileWriter;

public class TransactionFile  implements TransactionFileProcess
{
    private static String transactionFile;
    static
    {
        transactionFile = "src/com/atmservice/filedatabase/transaction.txt";
    } 
    public  List<Transaction> readTransactionFile() throws Exception
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
            LoginView.alert("File Not Found");
        }
        return transactions;
    }
    public  void writeTransactionFile(Transaction transaction)  throws Exception
    {
        try (PrintWriter file = new PrintWriter(new FileWriter(transactionFile,true)))
        {
          file.println(transaction.getTransactionNo()+"," + transaction.getAccountNo()+"," + transaction.getTransferType() +"," + transaction.getAmount()+"," + transaction.getCurrentBalance()+"," +transaction.getCharge()+ "," + transaction.getDate()+"," + transaction.getTime());
          file.flush();
        }
        catch(FileNotFoundException e)
        {
            LoginView.alert("File Not Found");
        } 
    }
}
