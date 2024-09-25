package com.atmservice.login;
import java.util.Scanner;
import com.atmservice.customer.CustomerView;
import com.atmservice.manageaccount.ManageAccountView;
public class LoginView 
{
    private LoginModelView loginModel;
    static Scanner scan = new Scanner(System.in);
	public LoginView() 
    {
		loginModel = new LoginModelView(this);
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
        new ManageAccountView().init();
    }
    public static void alert(String str) 
    {
        System.out.println(str);
    }
}