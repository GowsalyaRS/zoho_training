package com.solidprinciple.liskov_substitution.good;
public class GoodOperationDemo 
{
    public static void main(String[] args) 
    {
        Bike electricBike = new ElectricBike();
        electricBike.drive();
    }
}
