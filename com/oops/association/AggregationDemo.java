package com.oops.association;
public class AggregationDemo 
{
    public static void main(String[] args) 
    {
        Music song = new Music("aaaa...!", "ABC");
        Bus bus = new Bus("xyz",song);
        bus.startMusic();
    }
}
