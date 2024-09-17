package com.oops.coupling;
public class TightCouplingDemo 
{
    public static void main(String[] args) {
        PDFDoucument doucument = new PDFDoucument();
        doucument.print();
    }
}
