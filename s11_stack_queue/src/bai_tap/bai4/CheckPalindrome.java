package bai_tap.bai4;

import java.util.Scanner;
import java.util.Stack;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string you want to check:");
        String str = sc.nextLine();
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        String reserveStr = "";
        while (!stack.isEmpty()) {
            reserveStr = reserveStr + stack.pop();
        }
        if (str.equals(reserveStr)) {
            System.out.println("This is a symmetrical sequence.");
        } else {
            System.out.println("This is not a symmetrical sequence.");
        }
    }
}
