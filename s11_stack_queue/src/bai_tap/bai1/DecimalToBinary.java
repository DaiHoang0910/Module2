package bai_tap.bai1;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public void concertBinary(int num) {
        Stack<Integer> stack = new Stack<Integer>();
        while (num != 0) {
            int digit = num % 2;
            stack.push(digit);
            num /= 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int decimalNumber = sc.nextInt();
        while (decimalNumber < 0) {
            System.out.println("Invalid number");
            System.out.println("Enter a number: ");
            decimalNumber = sc.nextInt();
        }
        System.out.println("Binary system of " + decimalNumber + " :");
        new DecimalToBinary().concertBinary(decimalNumber);
    }
}
