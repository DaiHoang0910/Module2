package Circle;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(5);
        circle.setColor("red");
        System.out.println("Area of circle: " + circle.getArea());
        System.out.println("Color of circle: " + circle.getColor());

        Cylinder cylinder = new Cylinder(circle.getRadius(), circle.getColor(), 10 );
        System.out.println("Total of cylinder: " + cylinder.getVolume());

    }
}
