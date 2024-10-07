package shapes;

public class Circle extends Shape{
    int rad;
    Circle(String c,int r){
        super(c);
        this.rad=r;
    }
    Circle(){}
    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public int getArea(){
        return this.rad*22/7*2;
    }
    public int getParam(){
        return 2*22/7*this.rad;
    }
}
