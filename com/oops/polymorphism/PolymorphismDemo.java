package com.oops.polymorphism;
public class PolymorphismDemo
{
    public static void main (String [] args)
    {
        Bird parrot = new Parrot(70,true);
        parrot.makeSound();
        parrot.makeSound(3);
        Bird peacock = new Bird(13);
        peacock.makeSound();
        peacock.makeSound(5);
    }
}
