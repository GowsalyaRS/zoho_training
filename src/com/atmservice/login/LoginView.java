package com.atmservice.login;
import java.util.Scanner;
import com.atmservice.manageaccount.ManageAccountView;

public class LoginView  implements LoginViewProcess
{
    private LoginViewModelProcess loginModel;
    static Scanner scan = new Scanner(System.in);
	public LoginView(LoginViewModel loginModel) 
    {
		this.loginModel = loginModel;
	}
    public void init() 
    {
        System.out.println("Enter the username ");
        String username = scan.nextLine();
        System.out.println("Enter the password ");
        String password = scan.nextLine();
        loginModel.validateCheck(username,password);
    }
    public void onSuccess() 
    {
        alert(" Successfully Login !");
        ManageAccountView.accountProcess();
    }
    public static void alert(String str) 
    {
        System.out.println(str);
    }
}