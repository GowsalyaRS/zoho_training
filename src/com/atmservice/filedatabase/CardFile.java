package com.atmservice.filedatabase;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.module.Account;
import com.atmservice.module.Card;
import com.atmservice.module.DebitCard;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class CardFile  implements CardFileProcess
{
    private static String cardFile;
    static
    {
        cardFile = "src/com/atmservice/filedatabase/card.txt";
    }
     public  List<Card> readCardFile() throws Exception 
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
            LoginView.alert("File Not Found");
        }
        return cards;
    }
    public  void writeCardFile(Card card) throws Exception
    {
        try (PrintWriter file = new PrintWriter(new FileWriter (cardFile,true)))
        {
          file.println(card.getCardNumber()+ ","+ card.getAccountNo()+","+ card.getPinNumber());
          file.flush();
        }
        catch(FileNotFoundException e)
        {
            LoginView.alert("File Not Found");
        }
    } 
    public  void modifyCardFile(Map<Long,Card> cards) throws Exception
    {
        clearFileContent(cardFile);
        addContent("Card No,Account No,Pin",cardFile);
        for (Card card : cards.values())
        {
            writeCardFile(card);
        } 
    }
}
