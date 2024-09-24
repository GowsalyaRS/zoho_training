package com.solidprinciple.open_close_principle.bad;

public class BadOperationDemo 
{
    public static void main(String[] args) 
    {
       Vehical car = new Vehical();  
       float carTollGateAmount =  car.calculateTollGateFees(VehicalType.CAR);
       System.out.println(carTollGateAmount);
       Vehical bike = new Vehical();  
       float bikeTollGateAmount =  car.calculateTollGateFees(VehicalType.BIKE);
       System.out.println(bikeTollGateAmount);
    }
}
