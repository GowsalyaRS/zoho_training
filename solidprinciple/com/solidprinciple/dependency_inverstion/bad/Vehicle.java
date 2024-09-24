package com.solidprinciple.dependency_inverstion.bad;
class Vehicle 
{
    private Car car ;
    Vehicle()
    {
        car = new Car();
    }
    void drive()
    {
        car.drive();
    }
}
