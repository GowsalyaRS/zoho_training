package com.oops.association;
public class CompositionDemo 
{
    public static void main(String[] args) 
    {
        Engine engine = new Engine("v7") ;
        Car bmw= new Car("BMW",engine);
        bmw.startCar(); 
    }
}
