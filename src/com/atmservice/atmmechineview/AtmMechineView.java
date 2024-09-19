package com.atmservice.atmmechineview;
import java.util.Scanner;
import com.atmservice.login.LoginModelView;
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
                System.out.println("1.CheckBalnce  \n2.Deposite    \n3.Withdraw  \n4.Swipe   \n5.Generate PIN  \n6.Change PIN    \n7.Exit");
                System.out.println("=========================================");
                System.out.println("Enter the option ");
                int option  = scan.nextInt();
                switch (option) 
                {
                    case 1: showBalance(atmCard);break;
                    case 2: deposit(atmCard);break;
                    case 3: withdraw(atmCard);break;
                    case 4: swipe(atmCard);break;
                    case 5: atmMechineModelView.generatePin(atmCard);break;
                    case 6: changePin(atmCard);
                    case 7:return;
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
        Long phoneNo = scan.nextLong();
        atmMechineModelView.validPhoneNumber(phoneNo,atmCard);
    }
    private void showBalance(AtmCard atmCard) 
    {
        System.out.println(" Your Current Balance :  USD "   + atmCard.showBalance()) ;
    }
    private void swipe(AtmCard atmCard) 
    {
        double amount = getAmount();
        String msg =  atmCard.swipe(amount);
        LoginView.alert(msg);
    }
    private void withdraw(AtmCard atmCard) 
    {
        double amount = getAmount();
        String msg = atmCard.withdraw(amount);
        LoginView.alert(msg);
    }
    private void deposit(AtmCard atmCard) 
    {
        double amount = getAmount();
        atmCard.deposit(amount);
    }
    private double getAmount() {
        System.err.println("Enter the amount ");
        double amount = scan.nextDouble();
        if(amount<0) 
           LoginView.alert("Amount only Positive Values.....!");
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
}
