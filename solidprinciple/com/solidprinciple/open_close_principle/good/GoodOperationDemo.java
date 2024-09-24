package com.solidprinciple.open_close_principle.good;

public class GoodOperationDemo 
{
    public static void main(String[] args) 
    {
        Vehicle car = new Car("BMW",50.0f);
        float tollGateAmount =  car.calculateTollGateFees();
        System.out.println(tollGateAmount);
    } 
}
