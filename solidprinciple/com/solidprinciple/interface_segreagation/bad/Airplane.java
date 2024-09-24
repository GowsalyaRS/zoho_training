package com.solidprinciple.interface_segreagation.bad;

public class Airplane  implements Vehicle
{
    public void fly() 
    {
       System.out.println("Airplane start flying");
    }
    public void startEngine() 
    {
        System.out.println("Airplane start engine");
    }
}
