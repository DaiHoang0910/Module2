import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        int n = 20;
        System.out.printf("%d số nguyên tố đầu tiên là: \n", n);
        int count = 0;
        int i = 2;
        while (count < n) {
            if(checkPrime(i)){
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
    }

    public static boolean checkPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
