package com.atmservice.atmmechineview;
import java.util.Scanner;
import com.atmservice.login.LoginView;
import com.atmservice.module.AtmCard;
import java.util.InputMismatchException;
public class AtmMechineView 
{
    private AtmMechineModelView atmMechineModelView;
    private Scanner scan;
    public AtmMechineView()
    {
       atmMechineModelView = new AtmMechineModelView(this);
       scan = new Scanner(System.in);
    }
    public void validCard()
    {
        System.out.println("Enter the card No ");
        Long cardNumber = scan.nextLong();
        atmMechineModelView.checkCardValidation(cardNumber);
    }
    public void init(AtmCard atmCard) 
    {
        LoginView.alert("\t\tWelcome " + atmCard.getCardName());
        while(true )
        {
            try
            {
                System.out.println("=========================================");
                System.out.println("1.CheckBalnce  \n2.Deposite    \n3.Withdraw  \n4.Swipe   \n5.Change PIN    \n6.Exit");
                System.out.println("=========================================");
                System.out.println("Enter the option ");
                int option  = scan.nextInt();
                switch (option) 
                {
                    case 1: showBalance(atmCard);break;
                    case 2: deposit(atmCard);break;
                    case 3: withdraw(atmCard);break;
                    case 4: swipe(atmCard);break;
                    case 5: changePin(atmCard);
                    case 6:return;
                    default: System.out.println("Enter the correct option");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Check your input ");
                scan.nextLine();
            }
        }
    }
    private void changePin(AtmCard atmCard) 
    {
        System.out.println("Enter the phoneNo ");
        long phoneNo = scan.nextLong();
        atmMechineModelView.validPhoneNumber(phoneNo,atmCard);
    }
    private void showBalance(AtmCard atmCard) 
    {
        System.out.println(" Your Current Balance :  USD "   + atmCard.showBalance()) ;
    }
    private void swipe(AtmCard atmCard) 
    {
        double amount = getAmount();
        atmMechineModelView.isSwipe(amount,atmCard);
    }
    private void withdraw(AtmCard atmCard) 
    {
        double amount = getAmount();
        atmMechineModelView.isWithdraw(amount,atmCard);
    }
    private void deposit(AtmCard atmCard) 
    {
        double amount = getAmount();
        atmMechineModelView.isDeposite(amount,atmCard);
    }
    private double getAmount() 
    {
        System.err.println("Enter the amount ");
        double amount = scan.nextDouble();
        return amount;
    }
    public void generatePin(AtmCard atmCard) 
    {
       System.out.println("Enter the pin number ");
       int pinNumber = scan.nextInt();
       atmMechineModelView.isValidPin(atmCard,pinNumber);
    }
    public void getPinNumber(AtmCard atmCard) 
    {
        System.out.println("Enter the pin number ");
        int pinNumber = scan.nextInt();
        atmMechineModelView.isValidPin(pinNumber,atmCard);
    }
    public void deposit(AtmCard atmCard, double amount) 
    {
        atmCard.deposit(amount);
        System.out.println("Deposit Successfully  USD  " + amount);
    }
    public void withdraw(double amount, AtmCard atmCard,double withdrawCharge) 
    {
        atmCard.withdraw(amount);
        System.out.println("Withdraw amount Successfully  USD  " + (amount-withdrawCharge) + "\n get amount charge  USD " + withdrawCharge );
    }
    public void swipe(double amount, AtmCard atmCard, double cashBack) 
    {
        atmCard.swipe(amount,cashBack);
        System.out.println("Your CashBack Amount USD : " + cashBack);
    }
}
