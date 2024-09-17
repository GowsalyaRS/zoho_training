package com.oops.encapsulation;
class Chair  // this class just a blueprint of objects, no occupy memory 
{
	private String brand;
	private float price;
	private String colour;
    private boolean isWood;  // data's encapsulated this class
	public Chair(String brand, float price, String colour, boolean isWood) {
		this.brand = brand;    // initialization values of  instance variable in runtime use constructor
		this.price = price;
		this.colour = colour;
		this.isWood = isWood;
	}
	public String getBrand() {  // private data access to another class verify check condition used getter setter methods
		return brand;
	}
	public float getPrice() {
		return price;
	}
	public String getColour() {
		return colour;
	}
	public boolean isWood() {
		return isWood;
	}
}
