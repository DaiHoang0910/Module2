package bai_tap.bai4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string you want to check:");
        String str = sc.nextLine();
        Queue<String> queue = new LinkedList<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            queue.add(String.valueOf(str.charAt(i)));
        }
        String reserveStr = "";
        while (!queue.isEmpty()) {
            reserveStr = reserveStr + queue.remove();
        }
        if (str.equals(reserveStr)) {
            System.out.println("This is a symmetrical sequence.");
        } else {
            System.out.println("This is not a symmetrical sequence.");
        }
    }
}
