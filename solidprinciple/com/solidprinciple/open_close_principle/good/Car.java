package com.solidprinciple.open_close_principle.good;
public class Car  extends Vehicle
{
    Car(String model,float amount)
    {
        super(model,amount);
    }
    float calculateTollGateFees() 
    {
       return  getTollGateAmount();
    }
}
