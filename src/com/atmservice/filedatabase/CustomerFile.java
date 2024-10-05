package com.atmservice.filedatabase;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.atmservice.login.LoginView;
import com.atmservice.module.Customer;

public class CustomerFile implements CustomerFileProcess
{
    private static String customerFile;
    static
    {
        customerFile    = "src/com/atmservice/filedatabase/customer.txt";
    }
     public  List<Customer> readCustomerFile() throws Exception {
        List<Customer> customers = new ArrayList();
        try (BufferedReader s = new BufferedReader(new FileReader(customerFile))) 
        {
            String n = s.readLine();
            n = s.readLine();
            while (n!= null && !n.isEmpty() && n!="\\s" ) 
            {
                String[] arr = n.split(",");
                String name = arr[0];
                long phoneNo = Long.parseLong(arr[1]);
                customers.add(new Customer(name, phoneNo));
                n = s.readLine();
            }
        } 
        catch (FileNotFoundException e) {
           
            LoginView.alert("File Not Found");
        }
        return customers;
    }
    public  void writeCustomerFile(Customer customer) throws Exception
    {
        try (PrintWriter file = new PrintWriter( new FileWriter(customerFile,true)))
        {
          file.println(customer.getName() + "," + customer.getPhoneNo());
          file.flush();
        }
        catch(FileNotFoundException e)
        {
            LoginView.alert("File Not Found");
        }
    } 
}
