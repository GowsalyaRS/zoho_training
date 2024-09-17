package com.oops.abstraction;
public class InterfaceDemo 
{
	public static void main(String[] args)
	{
		Playable guitar = new StringInstrument();
		guitar.play("Guitar");   // override the play method so execution of method is runtime reference 
	}
}
