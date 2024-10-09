package com.demo.beans;

public class Masters extends Student{
    private String thesisSubjectName;
    private int thesisMarks;

    public Masters(int id, String name, String address, int[] marks, String thesisSubjectName, int thesisMarks) {
        super(id, name, address, marks);
        this.thesisSubjectName = thesisSubjectName;
        this.thesisMarks = thesisMarks;
    }

    public String getthesisSubjectName() {
        return thesisSubjectName;
    }

    public void setthesisSubjectName(String thesisSubjectName) {
        this.thesisSubjectName = thesisSubjectName;
    }

    public int getThesisMarks() {
        return thesisMarks;
    }

    public void setThesisMarks(int thesisMarks) {
        this.thesisMarks = thesisMarks;
    }

    @Override
    public String toString() {
        return super.toString()+ "Masters{" +
                "thesisSubjectName='" +  + '\'' +
                ", thesisMarks=" + thesisMarks +
                '}';
    }
}
