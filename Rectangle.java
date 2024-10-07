package com.demo.beans;

public class Rectangle extends Shape{
    int length;
    int breadth;

    public Rectangle() {
    }

    public Rectangle(String c,int length, int breadth) {
        super(c);
        this.length = length;
        this.breadth = breadth;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", breadth=" + breadth +
                '}';
    }
    public double calcArea(){
        return 2*(length+breadth);
    }
    public  double calcParameter(){
        return this.length*this.breadth;
    }
}
