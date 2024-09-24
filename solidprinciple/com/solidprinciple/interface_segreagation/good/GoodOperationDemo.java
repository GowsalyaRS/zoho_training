package com.solidprinciple.interface_segreagation.good;

public class GoodOperationDemo 
{
    public static void main(String[] args) 
    {
        Drivable car = new Car();
        car.startEngine();
        Airplane airplane = new Airplane();
        airplane.fly();
        airplane.startEngine();
    }
}
