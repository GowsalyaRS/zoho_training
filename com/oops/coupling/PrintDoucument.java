package com.oops.coupling;

class PrintDoucument 
{
    private Doucumentable doucument;
    PrintDoucument(Doucumentable doucument)
    {
        this.doucument = doucument;
    } 
    void print()
    {
        doucument.print();
    }
}
