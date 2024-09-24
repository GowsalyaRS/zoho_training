package com.solidprinciple.single_responsible.bad;

public class BadOperationDemo 
{
    public static void main(String[] args) 
    {
        Vehicle car = new Vehicle("BMW") ;
        car.addDataBase();
        car.start();
        car.stop();
    }
}
