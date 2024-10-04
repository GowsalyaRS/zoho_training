import com.atmservice.atmmechineview.AtmMechineView;
import com.atmservice.atmmechineview.AtmMechineViewModel;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.login.LoginViewModel;
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
                    case 1  :  loginProcess();break;
                    case 2  :  atmProcess();break;
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
    private static void loginProcess() 
    {
       LoginViewModel loginViewModel = new LoginViewModel();
       LoginView loginView = new LoginView(loginViewModel);
       loginViewModel.setLoginView(loginView);
       loginView.init();
    }
    public static void atmProcess() throws Exception
    {
        AtmMechineViewModel aMechineViewModel = new AtmMechineViewModel();
        AtmMechineView atmMechineView = new AtmMechineView(aMechineViewModel);
        aMechineViewModel.setAtmMechineView(atmMechineView);
        atmMechineView.enterCardNumber();
    }
}
