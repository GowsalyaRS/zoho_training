package com.oops.abstraction;
class KeyboardInstrument implements Playable
{
     public void play(String instrumentName )  
     {
          System.out.println("Playing " + instrumentName);
     } 
}