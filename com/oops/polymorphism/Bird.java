package com.oops.polymorphism;

abstract class Bird 
{
    private int flyingKiloMeter;
    Bird(int flyingKiloMeter)
    {
        this.flyingKiloMeter = flyingKiloMeter;
    }
    abstract void makeSound();  // abstract method so child class overridding compulsory this method
    public void makeSound(int volume)   // overloaded method same name different argument
    {
        if(volume<5)
        {
            System.out.println("Low level sound");
        }
        else 
        {
            System.out.println("High level sound");
        }
    }
    public int getFlyingKiloMeter() {
        return flyingKiloMeter;
    } 

}