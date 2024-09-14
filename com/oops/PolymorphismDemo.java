package com.oops;
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
public class PolymorphismDemo
{
    public static void main (String [] args)
    {
        Bird parrot = new Parrot(70,true);
        parrot.makeSound();
        parrot.makeSound(3);
    }
}
