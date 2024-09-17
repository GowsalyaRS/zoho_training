package com.oops.polymorphism;
class Parrot extends Bird
{
    private boolean isSpeak;
    Parrot(int flyingKiloMeter,boolean isSpeak)
    {
       super(flyingKiloMeter);
       this.isSpeak = isSpeak;
    }
    
    public boolean isSpeak() {
        return isSpeak;
    }

    void makeSound() 
    {
        System.out.println("Squawk!");
    }
}
