package com.solidprinciple.dependency_inverstion.bad;

public class BadOperationDemo 
{
    public static void main(String[] args) 
    {
       VehicleManagement bike = new VehicleManagement(new Bike());
       bike.drive();
    }
}
