package com.solidprinciple.open_close_principle.good;
public  abstract class Vehicle 
{
    private  String model;  
    private float tollGateAmount;
    Vehicle(String model,float tollGateAmount)
    {
       this.model = model;
       this.tollGateAmount = tollGateAmount;
    } 
    abstract float calculateTollGateFees();
    public String getModel() {
        return model;
    }
    public float getTollGateAmount() {
        return tollGateAmount;
    }
}
