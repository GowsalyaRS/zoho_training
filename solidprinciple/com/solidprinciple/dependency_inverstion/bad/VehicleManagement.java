package com.solidprinciple.dependency_inverstion.bad;

public class VehicleManagement 
{
    private Bike bike;
    VehicleManagement()
    {
        bike = new Bike();
    }
    void drive()
    {
        bike.drive();
    }
}
