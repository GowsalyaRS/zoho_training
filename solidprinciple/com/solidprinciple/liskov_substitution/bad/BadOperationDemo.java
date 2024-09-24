package com.solidprinciple.liskov_substitution.bad;
public class BadOperationDemo 
{
    public static void main(String[] args) 
    {
        Bike bike = new ElectricBike();
        bike.drive();   
    }
}
