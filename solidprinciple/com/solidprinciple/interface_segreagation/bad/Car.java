package com.solidprinciple.interface_segreagation.bad;
class Car implements Vehicle
{
    public void fly() 
    {
        System.out.println("Unimplemented method 'fly'");
    }
    public void startEngine() 
    {
        System.out.println("Car start the engine......");
    }
}