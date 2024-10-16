import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {

    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return (b * b - 4 * a * c);
    }

    
    public double getRoot1() {
        if (this.getDiscriminant() < 0) return 0;
        return ((-b + Math.sqrt(getDiscriminant())) / (2 * a));
    }

    public double getRoot2() {
        if (this.getDiscriminant() < 0) return 0;
        return ((-b - Math.sqrt(getDiscriminant())) / (2 * a));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a;
        double b;
        double c;
        System.out.println("Quadratic Equation: Ax^2 + Bx + C = 0");
        System.out.println("Enter input number A: ");
        a = sc.nextDouble();
        System.out.println("Enter input number B: ");
        b = sc.nextDouble();
        System.out.println("Enter input number C: ");
        c = sc.nextDouble();
        if (a != 0) {
            QuadraticEquation equation = new QuadraticEquation(a, b, c);
            if (equation.getDiscriminant() < 0) {
                System.out.println("The equation has no root");
            } else if (equation.getDiscriminant() == 0) {
                System.out.println("Delta: " + equation.getDiscriminant());
                System.out.println("The equation has 1 root: " + (-b / (2 * a)));
            } else {
                System.out.println("The equation has 2 root: ");
                System.out.println("Delta: " + equation.getDiscriminant());
                System.out.println("Root1 : " + equation.getRoot1());
                System.out.println("Root2 : " + equation.getRoot2());
            }
        } else {
            if (b == 0 && c == 0) {
                System.out.println("The equation has infinitely many solutions.");
            } else {
                if (b == 0) {
                    System.out.println("The equation has no root");
                } else if (c == 0) {
                    System.out.println("The equation has root = 0");
                } else {
                    System.out.println("The equation has 1 root: " + (-c / b));
                }
            }
        }

    }

}
