package com.solidprinciple.single_responsible.good;
public class GoodOperationDemo 
{
    public static void main(String[] args) 
    {
        Vehicle car = new Vehicle("BMW");
        car.start();
        car.stop();
        VehicleRepository dataBase = new VehicleRepository();
        dataBase.storedVihicleData(car);
    }
}
