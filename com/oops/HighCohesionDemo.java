package com.oops;
class Animal 
{
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void speak() {
        System.out.println(name + " makes a sound.");
    }
    public void eating() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eating'");
    }
}
public class HighCohesionDemo {
    public static void main(String[] args) {
        Animal lion = new Animal( "Lion");
        lion.speak();
    }
}
