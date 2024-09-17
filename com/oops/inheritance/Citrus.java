package com.oops.inheritance;

class Citrus extends Fruit 
{
    private float acidicQuantity;
    public Citrus(String color, float gram, float acidicQuantity) {
        super(color, gram); 
        this.acidicQuantity = acidicQuantity;
    }
    public float  getAcidicQuantity() {
        return acidicQuantity;
    }
}