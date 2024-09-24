package com.solidprinciple.dependency_inverstion.bad;

public class VehicleManagement 
{
    private Bike bike;
    VehicleManagement(Bike bike)
    {
        this.bike = bike;
    }
    void drive()
    {
        bike.drive();
    }
}
