package com.solidprinciple.liskov_substitution.bad;
public class BadOperationDemo 
{
    public static void main(String[] args) 
    {
        Vehicle boat = new Boat();
        boat.drive(); 
        
        Car car = new Car();
        car.drive();
    }
}
