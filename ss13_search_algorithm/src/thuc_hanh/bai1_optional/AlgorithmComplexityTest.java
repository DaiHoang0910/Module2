package thuc_hanh.bai1_optional;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputStr = sc.nextLine();

        int[] frequentChar = new int[255];
        for (int i = 0; i < inputStr.length(); i++) {
            int ascii = (int) inputStr.charAt(i);
            frequentChar[ascii]++;
        }

        int max = 0;
        char character = (char) 255;
        for (int i = 0; i < 255; i++) {
            if (frequentChar[i] > max) {
                max = frequentChar[i];
                character = (char) i;
            }
        }
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }
}
