package com.solidprinciple.liskov_substitution.bad;

public class Boat  extends Vehicle
{
    void drive()
    {
        throw new UnsupportedOperationException("Boats do not start in the same way as vehicles.");
    } 
    void move()
    {
        System.out.println("Move the Boat on Water");
    }
}
