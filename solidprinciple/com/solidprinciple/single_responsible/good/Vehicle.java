package com.solidprinciple.single_responsible.good;
public class Vehicle 
{
    private  String model;  
    Vehicle (String model)
    {
      this.model = model;
    }
    public String getModel()
    {
        return model;
    }
    void start()
    {
        System.out.println("Start  Vehicle Model  is : " + model); 
    }
    void stop ()
    {
        System.out.println("Stop Vehicle  Model  is : " + model); 
    }
}
