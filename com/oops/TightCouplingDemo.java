package com.oops;
class PDFDoucument 
{
    public void print()
    {
       System.out.println("PDF doucument printing");
    }
}
public class TightCouplingDemo 
{
    public static void main(String[] args) {
        PDFDoucument doucument = new PDFDoucument();
        doucument.print();
    }
}
