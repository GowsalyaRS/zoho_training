package com.oops;
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
public class HierarchyDemo 
{
	public static void main(String[] args) 
	{
		Fruit orange = new Citrus("Orange", 340.5f, 0.003f);
		Fruit strawberry = new Berry("Red", 13.2f, 0.5f);
	}
}
