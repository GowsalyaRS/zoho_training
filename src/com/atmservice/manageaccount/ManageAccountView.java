package com.atmservice.manageaccount;
import java.util.Scanner;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.module.Account;
import com.atmservice.module.AtmCard;
import com.atmservice.module.Customer;
import com.atmservice.module.XyzBankAccount;
import java.util.InputMismatchException;
public class ManageAccountView 
{
    private ManageAccountModelView accountModelView;
    Scanner scan ;
    public ManageAccountView()
    {
        scan = new Scanner(System.in);
        accountModelView = new ManageAccountModelView(this);
    }
    public void init() 
    {
        while(true)
        {
            try {
                System.out.println("=====================================");
                System.out.println("1.Create Account  \n2.Provide ATM card  \n3.Exit");  
                System.out.println("=====================================");
                System.out.println("Enter the option");
                int option = scan.nextInt();
                switch (option) 
                {
                    case 1: scan.nextLine();createAccount();break;
                    case 2: provideATMCard();break;
                    case 3: return;
                    default : System.out.println("Enter the correct option");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println(" check your input ");
                scan.nextLine();
            }
        }
    }
    private void provideATMCard() 
    {
       System.out.println("Enter the Account no ");
       Long accountNumber = scan.nextLong();
       accountModelView.validAccount(accountNumber);
    }    
    private void createAccount() 
    {
        System.out.println("Enter the name ");
        String name = scan.nextLine();
        System.out.println("Enter the phoneNo "); 
        Long phoneNo = scan.nextLong();
        accountModelView.validCustomer(name,phoneNo);
    }
    public void createAccount(Customer customer) 
    {
        System.out.println("Enter the balance USD ");
        double amount = scan.nextDouble();
        accountModelView.validAmount(customer,amount);
    }
    public void createAccount(Customer customer, double amount) 
    {
        Account account = new XyzBankAccount(customer, amount);
        BankDataLayer bank =  BankDataLayer.getBankDataLayer();
        bank.setCustomer(customer);
        bank.setAccountDetails(account);
        LoginView.alert( "Your Account Number is "+  account.getAccountNumber()); 
    }
    public void provideATMCard(AtmCard card,Account account) 
    {
        BankDataLayer bank =  BankDataLayer.getBankDataLayer();
        bank.setAtmCard(card);
        bank.setAccountAtmCard(account, card);
        LoginView.alert("Your Atm card No : " + card.getCardNumber());
    }
}
