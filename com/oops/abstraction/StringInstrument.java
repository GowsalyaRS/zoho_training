package com.oops.abstraction;

class StringInstrument implements Playable
{
     public void play(String instrumentName )   // parent method scope is public so  override the method high or equal scope to provide compulsory
     {
          System.out.println("Playing " + instrumentName);
     }
}