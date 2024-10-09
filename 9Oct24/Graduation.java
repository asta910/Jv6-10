package com.demo.beans;

public class Graduation extends Student{
    private int specialSubMarks;

    public Graduation(int id, String name, String address, int[] marks, int specialSubMarks) {
        super(id, name, address, marks);
        this.specialSubMarks = specialSubMarks;
    }

    public int getSpecialSubMarks() {
        return specialSubMarks;
    }

    public void setSpecialSubMarks(int specialSubMarks) {
        this.specialSubMarks = specialSubMarks;
    }

    @Override
    public String toString() {
        return super.toString()+ "Graduation{" +
                "specialSubMarks=" + specialSubMarks +
                '}';
    }
}
