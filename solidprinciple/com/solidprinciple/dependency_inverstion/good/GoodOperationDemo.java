package com.solidprinciple.dependency_inverstion.good;

public class GoodOperationDemo 
{
    public static void main(String[] args) 
    {
       Bike bike = new Bike(); 
       VehicleManagement vehicle = new VehicleManagement(bike);
       vehicle.startEngine();
    } 
}
