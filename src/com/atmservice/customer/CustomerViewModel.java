package com.atmservice.customer;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.manageaccount.ManageAccountView;
import com.atmservice.module.Customer;

public class CustomerViewModel 
{
    private CustomerView customerView;
    public CustomerViewModel(CustomerView customerView) 
    {
        this.customerView = customerView;
    }
    public void isAvailableCustomer(Customer customer) 
    {
        if(BankDataLayer.getBankDataLayer().getCustomer().get(customer.getPhoneNo())!=null)
        {
           LoginView.alert("Already your create the account");
        }
        else
        {
            new ManageAccountView().createAccount(customer);
        }
    }
}