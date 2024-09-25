package com.solidprinciple.liskov_substitution.good;

public class Car  extends Vehicle implements Drivable
{
    public void drive()
    {
        System.out.println("Car driving");
    }
    void move()
    {
        System.out.println("move the car on road");
    }
}
