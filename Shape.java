package com.demo.beans;

abstract public class Shape {
    String color;

    public Shape() {
    }
    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                '}';
    }
    abstract public double calcArea();
    abstract public double calcParameter();
}
