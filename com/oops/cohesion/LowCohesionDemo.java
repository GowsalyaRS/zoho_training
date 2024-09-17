package com.oops.cohesion;
public class LowCohesionDemo 
{
    public static void main(String[] args) 
    {
        Animals cat = new Animals("cat");
        cat.speak();
        cat.eating();
    }
}
