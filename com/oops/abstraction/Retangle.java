package com.oops.abstraction;
class Retangle extends Shape
{
    private int length;
    private int width;
    public Retangle(int length, int width) {
        this.length = length;
        this.width = width;
    }
    void draw(String colour) // hiding internal details
    {
        System.out.println("Drawing a rectangle colour " + colour + " Length : " +   length + " width : " +  width);
    }
    public int getLength() {
        return length;
    }
    public int getWidth() {
        return width;
    }
}