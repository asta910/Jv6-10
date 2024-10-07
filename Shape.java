package shapes;

abstract  public class Shape {
    private String color;
    Shape(String s){
        this.color = s;
    }
    abstract public int getArea();
    abstract public int getParam();

    public String getColor() {
        return color;
    }
    Shape(){}
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                '}';
    }
}
