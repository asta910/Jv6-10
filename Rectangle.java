package shapes;

public class Rectangle extends Shape{
    int l,b;

    public Rectangle(String s, int l, int b) {
        super(s);
        this.l = l;
        this.b = b;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getArea(){
        return this.l*this.b;
    }
    public int getParam(){
        return 2*(this.l+this.b);
    }

}
