package shapes;

public class Triange extends Shape{
    int b;
    int h;
    int s1,s2;

    public Triange(String s, int b, int h, int s1, int s2) {
        super(s);
        this.b = b;
        this.h = h;
        this.s1 = s1;
        this.s2 = s2;
    }
    Triange(){}

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getS1() {
        return s1;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public int getS2() {
        return s2;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

    public int getArea(){
        return 1/2*b*h;
    }
    public int getParam(){
        return (b+s1+s2);
    }
}
