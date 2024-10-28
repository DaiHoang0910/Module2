package bai_tap.insertSort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

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
            insertionSort(arr);
            System.out.println("Sorted array: " + Arrays.toString(arr));
        }
    }
}
