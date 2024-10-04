package com.atmservice.manageaccount;
import java.util.Scanner;
import com.atmservice.customer.CustomerView;
import com.atmservice.customer.CustomerViewModel;
import com.atmservice.module.Account;
import com.atmservice.module.Customer;
import com.atmservice.module.DebitCard;
import java.util.InputMismatchException;
import com.atmservice.transaction.TransactionView;
import com.atmservice.transaction.TransactionViewModel;

public class ManageAccountView  implements AccountViewProcess
{
    private static AccountViewModelProcess accountViewModel;
    static Scanner scan  = new Scanner(System.in); 
    private static  TransactionView transactionView;
    public ManageAccountView(AccountViewModelProcess accountViewModel)
    {
        this.accountViewModel = accountViewModel; 
    }
    public void init() 
    {
        while(true)
        {
            try 
            {
                System.out.println("=====================================");
                System.out.println("1.Create Account  \n2.Provide Card  \n3.Transaction History \n4.Exit");  
                System.out.println("=====================================");
                System.out.println("Enter the option");
                int option = scan.nextInt();
                switch (option) 
                {
                    case 1  : scan.nextLine();getCustomerDetails();break;
                    case 2  : provideDebitCard() ;break;
                    case 3  : transaction();break;
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
    private void getCustomerDetails() 
    {
        CustomerViewModel customerViewModel = new  CustomerViewModel();
        CustomerView customerView = new CustomerView(customerViewModel);
        customerViewModel.setCustomerView(customerView);
        Customer customer =  customerView.enterCustomerData();
        if(customer!=null)
        {
            createAccount(customer);
        }
    }
    public void createAccount(Customer customer) 
    {
        System.out.println("Enter the balance USD ");
        double amount = scan.nextDouble();
        if(accountViewModel.validAmount(amount))
        {
            accountViewModel.createAccount(customer,amount);
        }
    }
    public void printAccountDetails(Account account) 
    {
        System.out.println( "Your Account Number is "+  account.getAccountNumber()); 
    }
    public static Account findAccount() 
    {
       System.out.println("Enter the Account no ");
       Long accountNumber = scan.nextLong();
       Account account =accountViewModel.validAccount(accountNumber); 
       return account;
    }  
    public void provideDebitCard()
    {
        Account account = findAccount();
        if(account!=null)
        {
           accountViewModel.provideDebitCard(account);
        }
        else
        {
            System.out.println("Account Number is Invalid..!");
        }
    }
    public void printDebitCard(DebitCard card) 
    {
        System.out.println("Your Debit card No : " + card.getCardNumber());
    }
    public static void accountProcess() 
    {
        ManageAccountViewModel accountViewModel = new ManageAccountViewModel();
        ManageAccountView accountView = new ManageAccountView(accountViewModel);
        accountViewModel.setAccountView(accountView);
        accountView.init();
    }
    public  static TransactionViewModel transactionProcess() 
    {
        TransactionViewModel transactionViewModel = new TransactionViewModel();
        transactionView = new TransactionView(transactionViewModel);
        transactionViewModel.setTransactionView(transactionView);
        return transactionViewModel;
    }
    public void transaction()
    {
        transactionProcess();
        transactionView.printAccountNumber();
    }
}
