package com.solidprinciple.dependency_inverstion.good;

public class VehicleManagement 
{
    private Vehicle vehicle;
    VehicleManagement(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }
    void startEngine()
    {
        vehicle.startEngine();
    }
}
