package bai_tap.bai1;


public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3, "yellow", false);
        shapes[1] = new Rectangle(3, 8, "blue", true);
        shapes[2] = new Square(4, "red", false);
        for (Shape a : shapes) {
            System.out.println(a);
        }

        for (Shape a : shapes) {
            a.resize(Math.random() * 10);
        }
        System.out.println("\n");
        for (Shape a : shapes) {
            System.out.println(a);
        }
    }
}

