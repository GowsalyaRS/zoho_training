package com.oops.polymorphism;

class Bird 
{
    private int flyingKiloMeter;
    Bird(int flyingKiloMeter)
    {
        this.flyingKiloMeter = flyingKiloMeter;
    }
     void makeSound()  
     {
         System.out.println("bird making a sound");
     }
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