package com.atmservice.customer;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.atmservice.login.LoginView;
import com.atmservice.module.Customer;

public class CustomerView 
{
    private CustomerViewModel customerViewModel;
    private Scanner scan ;
    public CustomerView()
    {
        customerViewModel = new CustomerViewModel(this);
        scan = new Scanner(System.in);
    }
    public void addCustomer() 
    {
        String name = getName(); 
        long phoneNo = getPhoneNumber();
        Customer customer = new Customer(name,phoneNo);
        customerViewModel.isAvailableCustomer(customer);
    }
    private Long getPhoneNumber() 
    {
        boolean flag = true;
        long phoneNo = 0;
        while(flag) 
        {
            System.out.println("Enter the Phone number");
            phoneNo  = scan.nextLong();
            if(isValidPhoneNumber(phoneNo))
            {
               flag = false;
            }
        }
        return phoneNo;
    }
    private boolean isValidPhoneNumber(long phoneNo) 
    {
        Pattern ptrn = Pattern.compile("[6-9][0-9]{9}");
        Matcher  matcher  = ptrn.matcher(""+phoneNo);
        if(!matcher.matches())
        {
            LoginView.alert("Phone number is Invalid");
            return false;
        }
        return true;
    }
    private String getName() 
    {
        boolean flag = true;
        String name = null;
        while(flag) 
        {
            System.out.println("Enter the name");
            name = scan.nextLine();
            if(isValidName(name))
            {
               flag = false;
            }
        }
        return name;
    }
    public boolean isValidName(String name)
    {
        Pattern ptrn = Pattern.compile("[A-Z]*[a-z]+");
        Matcher  matcher  = ptrn.matcher(name);
        if(!matcher.matches())
        {
            LoginView.alert(" Name is Invalid");
            return false;
        }
        return true;
    }

}
