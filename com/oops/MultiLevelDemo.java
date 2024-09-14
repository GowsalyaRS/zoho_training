package com.oops;
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
class Orange extends Citrus 
{
	private String variety;
	public Orange(String color, float gram, float acidicQuantity, String variety) 
	{
	    super(color,gram, acidicQuantity); 
	    this.variety = variety;
	}
	public String getVariety() {
	    return variety;
	}
}
public class MultiLevelDemo 
{
	public static void main(String[] args) 
	{
		Fruit orange = new Orange("Orange", 12.4f,0.005f , "Navel");
	}
}
