import java.util.Scanner;

public class SumDiagonalOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        while (true) {
            try {
                System.out.print("Enter the size of the matrix: ");
                size = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc.nextInt();
                continue;
            }
            if (size <= 0) {
                System.out.println("Invalid input");
                continue;
            }
            break;
        }
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                while (true) {
                    try {
                        System.out.print("Enter the value of matrix[ " + i + "][" + j + "] : ");
                        matrix[i][j] = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                        sc.nextLine();
                        continue;
                    }
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println("The sum of the diagonal of square matrix is : " + sum);
    }
}
