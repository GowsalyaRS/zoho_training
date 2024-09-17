package com.oops.coupling;
public class LoseCouplingDemo {
    public static void main(String[] args) 
    {
       Doucumentable doucument = new WordDoucument();
       doucument.print();
    }
}
