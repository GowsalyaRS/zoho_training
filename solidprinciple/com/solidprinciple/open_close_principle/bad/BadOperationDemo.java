package com.solidprinciple.open_close_principle.bad;

public class BadOperationDemo 
{
    public static void main(String[] args) 
    {
       Vehical car = new Vehical();  
       float amount =  car.calculateTollGateFees(VehicalType.CAR);
       System.out.println(amount);
    }
}
