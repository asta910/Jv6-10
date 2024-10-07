package com.demo.beans;

public class Circle extends Shape{
   static final float pi = 3.142f;
    int radius;

    public Circle() {
    }

    public Circle(String c,int radius) {
        super(c);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString() + "Circle{" +
                "radius=" + radius +
                '}';
    }
    public  double calcArea(){
        return pi*radius*radius;
    }
    public  double calcParameter(){
        return 2*pi*radius;
    }
}
