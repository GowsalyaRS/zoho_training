package com.atmservice.customer;
import java.util.Scanner;
import com.atmservice.module.Customer;
import com.atmservice.validprocess.ValidInput;

public class CustomerView  implements CustomerViewProcess
{
    private CustomerViewModelProcess customerViewModel;
    private Scanner scan ;
    public CustomerView(CustomerViewModelProcess  customerViewModel)
    {
        this.customerViewModel =customerViewModel;
        scan = new Scanner(System.in);
    }
    public Customer enterCustomerData() 
    {
        String name = getName(); 
        long phoneNo = getPhoneNumber();
        Customer customer = new Customer(name,phoneNo);
        if(customerViewModel.isValidCustomer(customer)==false)
        {
            return customer;
        }
        return null;
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
    public void greatingMsg(String name)
    {
       System.out.println("Welcome" + name + " Your eligible for acccount creation");
    }
}