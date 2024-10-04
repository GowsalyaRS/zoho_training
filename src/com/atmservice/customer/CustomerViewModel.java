package com.atmservice.customer;
import com.atmservice.datalayer.BankDataLayer;
import com.atmservice.login.LoginView;
import com.atmservice.module.Customer;

public class CustomerViewModel  implements CustomerViewModelProcess
{
    private CustomerViewProcess customerView;
    public void setCustomerView(CustomerViewProcess customerView) 
    {
        this.customerView = customerView;
    }
    public boolean isValidCustomer(Customer customer) 
    {
        if(BankDataLayer.getBankDataLayer().getCustomer().get(customer.getPhoneNo())!=null)
        {
           LoginView.alert("Already create the account");
           return true;
        }
        customerView.greatingMsg(customer.getName());
        return false;
    }
}