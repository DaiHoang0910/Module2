import java.util.Scanner;

public class Geometry {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Draw the rectangle");
        System.out.println("2. Draw the triangle");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        choice = input.nextInt();
        String star = "*";
        switch (choice) {
            case 1:
                System.out.println("1. Draw the rectangle");
                for (int i = 1; i <= 4; i++) {
                    System.out.print(star);
                    for (int j = 1; j <= 12; j++) {
                        System.out.printf(star);
                    }
                    System.out.println();
                }
                break;
            case 2:
                System.out.println("2. Draw the triangle");
                for (int i = 1; i <= 7; i++) {

                    for (int j = 1; j <= i; j++) {
                        System.out.printf(star + "  ");
                    }
                    System.out.println();
                }
                System.out.println("-----------------------------");
                for (int i = 7; i >= 1; i--) {

                    for (int j = 1; j <= i; j++) {
                        System.out.printf(star + "  ");
                    }
                    System.out.println();
                }
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
