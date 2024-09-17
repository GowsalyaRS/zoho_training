package com.oops.polymorphism;
class Eagle extends Bird 
{
    private int visionRange;
    Eagle(int  flyingKiloMeter,int visionRange)
    {
        super(flyingKiloMeter);
        this.visionRange = visionRange;
    }
    void makeSound() 
    {
        System.out.println("Screech!");
    }
}