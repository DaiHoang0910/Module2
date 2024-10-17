package bai_tap.bai2;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3,"green",false);
        shapes[1] = new Rectangle(4,7,"red",false);
        shapes[2] = new Square(4,"blue",true);
        for (Shape a : shapes) {
            System.out.println(a);

            if (a instanceof Square) {
                Colorable colorable = (Square) a;
                System.out.println(colorable.howToColor());
            }
        }
    }
}
