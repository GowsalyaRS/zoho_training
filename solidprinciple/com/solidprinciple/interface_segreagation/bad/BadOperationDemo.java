package com.solidprinciple.interface_segreagation.bad;

public class BadOperationDemo 
{
    public static void main(String[] args) 
    {
        Vehicle car = new Car();
        car.fly();    // this method unimplemented this class
        car.startEngine();
    }
}
