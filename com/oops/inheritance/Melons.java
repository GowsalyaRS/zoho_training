package com.oops.inheritance;

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
