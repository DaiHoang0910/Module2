
public class SequencePrime {
    public static void main(String[] args) {
        System.out.print("số nguyên tố đầu tiên(<100) là: ");
        for (int i = 2; i <= 100; i++) {
            if (checkPrime(i)) {
                System.out.print(i + " ");
            }
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
