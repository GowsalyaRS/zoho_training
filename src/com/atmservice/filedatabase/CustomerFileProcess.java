package com.atmservice.filedatabase;
import com.atmservice.module.Customer;
import java.util.List;

public interface CustomerFileProcess 
{
     List<Customer> readCustomerFile() throws Exception ;
     void writeCustomerFile(Customer customer) throws Exception;
}
