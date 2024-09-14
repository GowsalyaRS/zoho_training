package com.oops;
interface Playable
{
    void play(String name);  //  interface inside this play method default compiler provide public abstract
}
class StringInstrument implements Playable
{
     public void play(String instrumentName )   // parent method scope is public so  override the method high or equal scope to provide compulsory
     {
          System.out.println("Playing " + instrumentName);
     }
}
class KeyboardInstrument implements Playable
{
     public void play(String instrumentName )  
     {
          System.out.println("Playing " + instrumentName);
     } 
}
public class InterfaceDemo 
{
	public static void main(String[] args)
	{
		Playable guitar = new StringInstrument();
		guitar.play("Guitar");   // override the play method so execution of method is runtime reference 
	}
}
