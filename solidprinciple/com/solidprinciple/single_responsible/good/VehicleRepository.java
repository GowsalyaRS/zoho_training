package com.solidprinciple.single_responsible.good;

public class VehicleRepository 
{
    public void storedVihicleData(Vehicle vehicle)
    {
        System.out.println(vehicle.getModel() + " Data stored successfully....");  
    }
}
