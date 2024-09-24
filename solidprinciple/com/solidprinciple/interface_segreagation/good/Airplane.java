package com.solidprinciple.interface_segreagation.good;

public class Airplane  implements Flyable,Drivable
{
    public void startEngine() {
        System.out.println("Starting Airplane engine...");
    }
    public void fly()
    {
        System.out.println("Flying the airplane...");
    }
}
