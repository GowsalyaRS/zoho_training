package com.atmservice.atmmechineview;
import java.util.Scanner;
import com.atmservice.card.CardService;
import com.atmservice.login.LoginView;
import com.atmservice.module.Card;
import java.util.InputMismatchException;

public class AtmMechineView 
{
    private AtmMechineViewModel atmMechineViewModel;
    private Scanner scan;
    public AtmMechineView()
    {
       atmMechineViewModel = new AtmMechineViewModel(this);
       scan = new Scanner(System.in);
    }
    public void validCard() throws Exception
    {
        System.out.println("Enter the card No "); 
        long cardNumber = scan.nextLong();
        atmMechineViewModel.checkCardValidation(cardNumber);
    }
    public void init(CardService cardService,Card card) 
    { 
        LoginView.alert("\t\tWelcome " + card.getCardName());
        while(true)
        {
            try
            {
                System.out.println("=========================================");
                System.out.println("1.CheckBalance  \n2.Deposite    \n3.Withdraw  \n4.Swipe   \n5.Change PIN    \n6.Exit");
                System.out.println("=========================================");
                System.out.println("Enter the option ");
                int option  = scan.nextInt();
                switch (option) 
                {
                    case 1: System.out.println (" Your current Balance : "+ cardService.showBalance());break;
                    case 2: cardService.deposit();break;
                    case 3: cardService.withdraw();break;
                    case 4: cardService.swipe();break;
                    case 5: changePin(card); break;
                    case 6: return;
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
    public void changePin(Card card) 
    {
        System.out.println("Enter the phoneNo ");
        long phoneNo = scan.nextLong();
        atmMechineViewModel.changePassword(card,phoneNo);
    }
    public int  generatePin() 
    {
       System.out.println("Enter the pin number ");
       int pinNumber = scan.nextInt();
       return pinNumber;
    }
   
}
