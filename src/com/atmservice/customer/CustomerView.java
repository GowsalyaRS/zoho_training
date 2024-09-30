package com.atmservice.customer;
import java.util.Scanner;
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
    public void addCustomer() throws Exception 
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
            if(ValidInput.isValidPhoneNumber(phoneNo))
            {
               flag = false;
            }
        }
        return phoneNo;
    }
    private String getName() 
    {
        boolean flag = true;
        String name = null;
        while(flag) 
        {
            System.out.println("Enter the name");
            name = scan.nextLine();
            if(ValidInput.isValidName(name))
            {
               flag = false;
            }
        }
        return name;
    }
}
