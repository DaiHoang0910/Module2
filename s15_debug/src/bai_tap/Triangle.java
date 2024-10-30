package bai_tap;

import java.util.Scanner;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalTriangleException("The sides of the triangle must not be less than 0.");
        }
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException("Invalid triangle");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public String toString() {
        return "Triangle with sides: " + side1 + ", " + side2 + ", " + side3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter the side1: ");
            double side1 = sc.nextDouble();
            System.out.print("Enter the side2: ");
            double side2 = sc.nextDouble();
            System.out.print("Enter the side3: ");
            double side3 = sc.nextDouble();

            Triangle triangle = new Triangle(side1, side2, side3);
            System.out.println(triangle.toString());
        } catch (IllegalTriangleException e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
