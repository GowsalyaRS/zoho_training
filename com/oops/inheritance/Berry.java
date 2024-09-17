package com.oops.inheritance;
class Berry extends Fruit 
{
    private float ellagicAcidGram;
    public Berry(String color, float gram,float ellagicAcidGram ) 
    {
        super(color, gram);
        this.ellagicAcidGram =  ellagicAcidGram;
    }
    public float getEllagicAcidGram() {
        return ellagicAcidGram;
    }
}
