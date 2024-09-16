package com.oops;
 interface Doucument 
 {
    void print();   
 }
 class WordDoucument implements Doucument
 {
    public void print()
    {
        System.out.println("Word Doucument printing");
    }
 } 
public class LoseCouplingDemo {
    public static void main(String[] args) 
    {
       Doucument doucument = new WordDoucument();
       doucument.print();
    }
}
