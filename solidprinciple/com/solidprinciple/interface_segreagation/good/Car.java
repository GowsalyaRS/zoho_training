package com.solidprinciple.interface_segreagation.good;

public class Car  implements Drivable
{
    public void startEngine()
    {
       System.err.println("Car Engine started");
    }
}
