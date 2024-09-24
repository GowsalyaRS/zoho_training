package com.solidprinciple.open_close_principle.good;

public class Bike extends Vehicle
{
    Bike(String model,float amount)
    {
        super(model,amount);
    }
    float calculateTollGateFees() 
    {
       return  getTollGateAmount();
    }
}
