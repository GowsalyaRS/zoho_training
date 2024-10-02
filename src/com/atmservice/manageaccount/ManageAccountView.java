package com.atmservice.manageaccount;
import java.util.Scanner;
import com.atmservice.customer.CustomerView;
import com.atmservice.module.Account;
import com.atmservice.module.Customer;
import com.atmservice.module.DebitCard;
import java.util.InputMismatchException;
import com.atmservice.transaction.TransactionView;

public class ManageAccountView 
{
    private ManageAccountViewModel accountViewModel;
    Scanner scan ;
    public ManageAccountView()
    {
        scan = new Scanner(System.in);
        accountViewModel= new ManageAccountViewModel(this);
    }
    public void init() 
    {
        while(true)
        {
            try {
                System.out.println("=====================================");
                System.out.println("1.Create Account  \n2.Provide Card  \n3.Transaction History \n4.Exit");  
                System.out.println("=====================================");
                System.out.println("Enter the option");
                int option = scan.nextInt();
                switch (option) 
                {
                    case 1  : scan.nextLine();createAccount();break;
                    case 2  : provideDebitCard() ;break;
                    case 3  : new TransactionView().getHistory();break;
                    case 4  : return;
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
    private void createAccount() 
    {
        new CustomerView().addCustomer();
    }
    public void createAccount(Customer customer) 
    {
        System.out.println("Enter the balance USD ");
        double amount = scan.nextDouble();
        accountViewModel.validAmount(customer,amount);
    }
    public void detailsAccount(Account account) 
    {
        System.out.println( "Your Account Number is "+  account.getAccountNumber()); 
    }
    public Account findAccount() 
    {
       System.out.println("Enter the Account no ");
       Long accountNumber = scan.nextLong();
       Account account =accountViewModel.validAccount(accountNumber); 
       return account;
    }  
    public void provideDebitCard()
    {
        Account account = findAccount();
        try
        {
           provideDebitCard(account);
        }
        catch(Exception e)
        {
          System.out.println(e.getMessage());
        }
    }
    public void provideDebitCard(Account account) throws Exception 
    {
       if(account!=null)
       {
          accountViewModel.addAccountDetails(account);
       }
       else
       {
           System.out.println("Account Number is Invalid..!");
       }
    }
    public void provideDebitCard(DebitCard card) 
    {
        System.out.println("Your Debit card No : " + card.getCardNumber());
    }
}
