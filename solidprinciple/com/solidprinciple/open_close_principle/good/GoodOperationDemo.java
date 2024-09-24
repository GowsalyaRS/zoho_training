package com.solidprinciple.open_close_principle.good;

public class GoodOperationDemo 
{
    public static void main(String[] args) 
    {
        Vehicle car = new Car("BMW",50.0f);
        float carTollGateAmount =  car.calculateTollGateFees();
        System.out.println( "Car Tollgate Amount   : "+  carTollGateAmount);
        Vehicle bike = new Bike("Hero",30.0f);
        float bikeTollGateAmount= bike.calculateTollGateFees();
        System.out.println( "Bike Tollgate Amount  : " +   bikeTollGateAmount);
    } 
}
