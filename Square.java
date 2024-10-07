package shapes;

public class Square extends Shape{
    int size;

    public Square(String s, int size) {
        super(s);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getArea(){
        return this.size*size;
    }
    public int getParam(){
        return this.size*4;
    }
}
