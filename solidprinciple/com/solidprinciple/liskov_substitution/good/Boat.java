package com.solidprinciple.liskov_substitution.good;
public class Boat extends Vehicle
{
    public void sail() 
    {
        System.out.println("Sailing the boat");
    }
    void move()
    {
        System.out.println("Move the Boat on Water");
    }
}
