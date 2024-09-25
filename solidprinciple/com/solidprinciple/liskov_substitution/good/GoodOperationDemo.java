package com.solidprinciple.liskov_substitution.good;
public class GoodOperationDemo 
{
    public static void getDrivable (Drivable vehicle)
    {
        vehicle.drive();
    }
    public static void main(String[] args) 
    {
        Car car = new Car();
        getDrivable(car);
        Vehicle boat = new Boat();
        boat.move();
    }
}
