package bai_tap.bai1;

import java.util.Arrays;
import java.util.Scanner;

public class ReserveArrayUsingStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        while (n < 0) {
            System.out.println("Error");
            System.out.println("Enter the number of elements in the array: ");
            n = sc.nextInt();
        }
        int[] arr = new int[n];
        if (n == 0) {
            System.out.println("Array is empty");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.printf("arr[%d] = ", i);
                arr[i] = sc.nextInt();
            }
            System.out.println("Initial array: " + Arrays.toString(arr));
            System.out.println("Array after reversal: " + Arrays.toString(reserveArray(arr)));
        }
    }

    public static int[] reserveArray(int[] arr) {
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

}
