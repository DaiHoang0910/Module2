import java.util.Scanner;

public class MaxInMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows;
        while (true){
            try {
                System.out.print("Enter the number of rows : ");
                rows = sc.nextInt();
            }catch (Exception e){
                System.out.println("Invalid input");
                sc.nextLine();
                continue;
            }
            if (rows <= 0){
                System.out.println("Invalid input");
                continue;
            }
            break;
        }

        int cols;
        while (true){
            try {
                System.out.print("Enter the number of columns : ");
                cols = sc.nextInt();
            }catch (Exception e){
                System.out.println("Invalid input");
                sc.nextLine();
                continue;
            }
            if (cols <= 0){
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
        int max = matrix[0][0];
        for (int i = 1; i < rows; i++){
            for (int j = 1; j < cols; j++){
                if (matrix[i][j] > max){
                    max = matrix[i][j];
                }
            }
        }
        System.out.println("Max of matrix: "+max);

    }
}
