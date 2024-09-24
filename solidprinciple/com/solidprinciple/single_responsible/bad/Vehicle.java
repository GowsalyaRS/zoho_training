package com.solidprinciple.single_responsible.bad;
public class Vehicle 
{
    private  String model;
    Vehicle (String model)
    {
      this.model = model;
    }
    void start()
    {
        System.out.println("Start the Vehicle model  : " + model); 
    }
    void stop()
    {
        System.out.println("Stop the Vehicle model  : " + model); 
    }
    void addDataBase()
    {
       System.out.println("Add  database is successfully : " + model);
    }
}
