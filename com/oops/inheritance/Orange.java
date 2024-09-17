package com.oops.inheritance;
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
