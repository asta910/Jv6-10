package shapes;

import java.util.Scanner;

public class Operations {
    static Shape[] array;
    static int count;
    static Scanner sc = new Scanner(System.in);
    static {
        count = 0;
        array = new Shape[10];
    }

    //create shape
    public static boolean createShape(){
        System.out.println("Which shape you want to add ? ");
        System.out.println("1. Circle \n2. Square \n3. Triangle \n4. Rectangle");
        System.out.print("Select option : ");
        int choice = sc.nextInt();
        if(choice == 1){
            System.out.print("Enter color :");
            String circleC = sc.next();
            System.out.print("Enter radius of circle : ");
            int circleR = sc.nextInt();
            Circle newCircle = new Circle(circleC,circleR);
            array[count++] = newCircle;
            return true;
        } else if (choice == 2) {
            System.out.print("Enter color :");
            String squareC = sc.next();
            System.out.print("Enter side of square : ");
            int squareR = sc.nextInt();
            Square newCircle = new Square(squareC,squareR);
            array[count++] = newCircle;
            return true;
        } else if (choice == 3) {
            System.out.print("Enter color of Triangle :");
            String  triangleC = sc.next();

            System.out.print("Enter base of Triangle: ");
            int base = sc.nextInt();

            System.out.print("Enter height of Triangle : ");
            int height= sc.nextInt();

            System.out.print("Enter side1 of Triangle : ");
            int side1 = sc.nextInt();

            System.out.print("Enter side2 of Triangle : ");
            int side2 = sc.nextInt();

            Triange newTriangle = new Triange(triangleC,base,height,side1,side2);
            array[count++] = newTriangle;
            return true;
        }else if(choice == 4){
            System.out.print("Enter color of Rectangle :");
            String  rectangleC = sc.next();

            System.out.print("Enter width og Rectangle : ");
            int w = sc.nextInt();

            System.out.print("Enter length of Rectangle : ");
            int l= sc.nextInt();

            Rectangle newRectangle = new Rectangle(rectangleC,l,w);
            array[count++] = newRectangle;
            return true;
        }
        return false;
    }

    //2 getCount
    public static void getShapeCount() {
        int tc = 0, sc = 0, rc = 0, cc = 0;
        for (int i = 0; i < count; i++) {
            if(array[i] instanceof Square) sc++;
            else if( array[i] instanceof  Triange) tc++;
            else if(array[i] instanceof Circle) cc++;
            else rc++;
        }
        System.out.println("Number of Circles in array is : " + cc);
        System.out.println("Number of Rectangles in array is : " + rc);
        System.out.println("Number of Squares in array is : " + sc);
        System.out.println("Number of Triangles in array is : " + tc);
    }

    //3 delete Shapes
    public static boolean deleteShape(){
        System.out.println("Which shape you want to delete ? ");
        System.out.println("1. Circle \n2. Square \n3. Triangle \n4. Rectangle");
        System.out.print("Select option : ");
        int choice = sc.nextInt();

        if(choice == 1){
            int ct = getCircleCount();
            while (ct != 0){
                for (int i = 0; i < count; i++) {

                    if(array[i] instanceof  Circle) {
                        for(int j = i ; j < count; j++) {
                            array[j] = array[j+1];
                        }
                        array[count--] = null;
                    }
                }
                ct--;
            }
            return true;
        }
        else if(choice == 2){
            int ct = squareCount();
            while (ct != 0){
                for (int i = 0; i < count; i++) {
                    if(array[i] instanceof  Square) {
                        for(int j = i ; j < count; j++) {
                            array[j] = array[j+1];
                        }
                        array[count--] = null;
                    }
                }
                ct--;
            }
            return true;
        }
        else if(choice == 3){
            int ct = teiCount();
            while (ct != 0){
                for (int i = 0; i < count; i++) {
                    if(array[i] instanceof  Triange) {
                        for(int j = i ; j < count; j++) {
                            array[j] = array[j+1];
                        }
                        array[count--] = null;
                    }
                }
                ct--;
            }
            return true;
        }
        else if (choice == 4){
            int ct = rectCount();
            while (ct != 0){
                for (int i = 0; i < count; i++) {
                    if(array[i] instanceof  Rectangle) {
                        for(int j = i ; j < count; j++) {
                            array[j] = array[j+1];
                        }
                        array[count--] = null;
                    }
                }
                ct--;
            }
            return true;
        }
        return false;
    }

    //4 get Areas by index
    static String[] shapeArray = {"Circle","Square", "Triangle","Rectangle"};
    public static void getAreaIndex(){
        for (int i =0; i < count; i++) {
            int index = 0;
            if(array[i] instanceof Square) index = 1;
            else if(array[i] instanceof Triange) index = 2;
            else if(array[i] instanceof Circle) index = 0;
            else index = 3;

            int area = ((Shape)array[i]).getArea();
            int param = ((Shape)array[i]).getParam();
            int ind = i + 1;
            System.out.println("Index " + ind + shapeArray[index]  + " area is : " + area + " and param is : " + param );
        }
    }

    //5 sort by area
    public static boolean sortByArea(){
        int[] areaArray = new int[count];
        for (int i =0; i < count; i++){
            areaArray[i] = ((Shape)array[i]).getArea();
        }
        for (int i =0; i < count; i++){
            for(int j = 0; j < count - i -1; j++) {
                if(areaArray[j] > areaArray[j+1]){
                    int a = areaArray[j];
                    areaArray[j] = areaArray[j+1];
                    areaArray[j+1] = a;
                    Shape temp = array[i];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }

        }
        return true;
    }

    private static int getCircleCount() {
        int cc = 0;
        for (int i = 0; i < count; i++) {
            if(array[i] instanceof Circle) cc++;
        }
        return cc;
    }
    private static  int squareCount() {
        int sc = 0;
        for (int i = 0; i < count; i++) {
            if(array[i] instanceof Square) sc++;
        }
        return sc;
    }
    private static int teiCount() {
        int sc = 0;
        for (int i = 0; i < count; i++) {
            if(array[i] instanceof Triange) sc++;
        }
        return sc;
    }
    private static int rectCount() {
        int sc = 0;
        for (int i = 0; i < count; i++) {
            if(array[i] instanceof Square) sc++;
        }
        return sc;
    }
}
