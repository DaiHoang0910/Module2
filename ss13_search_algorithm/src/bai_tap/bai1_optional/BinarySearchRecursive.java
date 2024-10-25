package bai_tap.bai1_optional;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        while (n < 0) {
            System.out.println("Error");
            System.out.println("Enter the size of the array: ");
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
            Arrays.sort(arr);
            System.out.println("Sorted array: " + Arrays.toString(arr));
        }
        System.out.println("Enter the element to be searched: ");
        int element = sc.nextInt();
        int result = binarySearchRecursive(arr, 0, n - 1, element);
        if (result != -1) {
            System.out.println("Element " + element + " found at index " + result);
        } else {
            System.out.println("Not found because the element does not exist in the array.");
        }
    }

    public static int binarySearchRecursive(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return binarySearchRecursive(arr, mid + 1, right, value);
        } else {
            return binarySearchRecursive(arr, left, mid - 1, value);
        }
    }
}
