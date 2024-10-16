import java.util.Scanner;

public class SumColsInMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows;
        while (true) {
            try {
                System.out.print("Enter the number of rows : ");
                rows = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc.nextLine();
                continue;
            }
            if (rows <= 0) {
                System.out.println("Invalid input");
                continue;
            }
            break;
        }

        int cols;
        while (true) {
            try {
                System.out.print("Enter the number of columns : ");
                cols = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc.nextLine();
                continue;
            }
            if (cols <= 0) {
                System.out.println("Invalid input");
                continue;
            }
            break;
        }

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                while (true){
                    try{
                        System.out.print("Enter the value of matrix[ "+i+"]["+j+"] : ");
                        matrix[i][j] = sc.nextInt();
                    }catch (Exception e){
                        System.out.println("Invalid input");
                        sc.nextLine();
                        continue;
                    }
                    break;
                }
            }
        }
        double sum = 0;
        int colsSum;
        while (true) {
            try {
                System.out.println("Enter the column to sum: ");
                colsSum = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc.nextLine();
                continue;
            }
            if (colsSum <= 0) {
                System.out.println("Invalid input");
                continue;
            }
            break;
        }
        for (int i = 0; i < rows; i++) {
            sum = sum + matrix[i][colsSum];
        }
        System.out.println("The sum of the matrix is : " + sum);
    }
}
