package thuc_hanh.bai2;

import java.awt.*;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        Circle circle1 = new Circle(2);
        System.out.println(circle1);

        Rectangle rectangle = new Rectangle(2,6);
        System.out.println(rectangle);

        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(5);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(7, "indigo", false);

        System.out.println("Pre-sorted: ");
        for(ComparableCircle circle : circles) {
            System.out.println(circle);
        }
        Arrays.sort(circles);
        System.out.println("After-sorted: ");
        for(ComparableCircle circle : circles){
            System.out.println(circle);
        }
    }
}
