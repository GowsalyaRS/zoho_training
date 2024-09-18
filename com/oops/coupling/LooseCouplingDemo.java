package com.oops.coupling;
public class LooseCouplingDemo {
    public static void main(String[] args) 
    {
       Doucumentable doucument = new WordDoucument();
       PrintDoucument printDoucument = new PrintDoucument(doucument);
       printDoucument.print();
    }
}
