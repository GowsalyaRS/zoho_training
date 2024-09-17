package com.oops.cohesion;
class Animals 
{
    private String name;
    public Animals(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void speak() {
        System.out.println(name + " makes a sound...!");
    }
    public void eating() {
        System.out.println( name + " is eating...!");
    }
    public void sleeping() {
        System.out.println( name + " is sleeping...!");
    }
}
