package com.oops.inheritance;
class Fruit 
{
    private String color;
    private float gram;
    public Fruit(String color, float gram) 
    {
        this.color = color;
        this.gram = gram;
    }
    public String getColor() {
        return color;
    }
    public float getGram() {
        return gram;
    }
}