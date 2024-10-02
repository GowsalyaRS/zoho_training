import com.atmservice.atmmechineview.AtmMechineView;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.module.Bank;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args)  throws Throwable
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Bank Name : ");
        String bankName = scan.nextLine();
        BankDataLayer.getInstance().setBankProperty(new Bank(bankName));
        System.out.println("\t\tWelcome "+ bankName + " Bank ");
        BankDataLayer.getInstance().setPerperty();
        while(true)
        { 
            try
            {
                System.out.println("=======================================");
                System.out.println("1.Admin  \n2.ATM Mechine  \n3.Exit");
                System.out.println("=======================================");
                System.out.println("Enter the option ");
                int option = scan.nextInt();
                switch (option) 
                {
                    case 1  :  new LoginView().init();break;
                    case 2  :  new AtmMechineView().validCard();break;
                    case 3  :  System.exit(0);
                    default :  System.out.println("Enter the correct option");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Enter the correct option");
                scan.nextLine();
            }
        }
    }
  
}
