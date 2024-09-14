package com.oops;
class  Melons extends Fruit
{
	private float  waterPercentage;
	public  Melons(String color, float gram,float  waterPercentage) {
		super(color, gram);
		this. waterPercentage = waterPercentage;
	}
	public float getWaterPercentage() {
		return waterPercentage;
	}
}
public class SingleInheritanceDemo
{
	public static void main(String[] args)
	{ 
	   Fruit  watermelon = new  Melons("green",6000.2f,56f);
	}
}
