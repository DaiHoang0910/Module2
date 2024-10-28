package bai_tap.illustration;

import java.util.Arrays;

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
        int[] arr = {4, 6, 3, 9, 1};
        System.out.println("Before insertion sort :" + Arrays.toString(arr));
        insertionSort(arr);
//        Quá trình sắp xếp chèn:
//        B1: Xem xét phần tử đầu tiên là "4" coi như đã được sắp xếp;
//        B2: So sánh phần tử thứ 2 với 4 ( 4 < 6)
//            Giữ nguyên vị trí
//        B3: Lấy phần tử tiếp theo "3" so sánh với các phần tử trước ( 6 > 3), (4 > 3)
//            Chèn "3" vào vị trí đầu tiên
//        B4: Lấy phần tử tiếp theo "9" so sánh với phần tử trước ( 9 > 6), (9 > 4), (9 > 3)
//            Giữ nguyên vị trí
//            Mảng hiện tại [3,4,6,9];
//        B5: Lấy "1" so sánh với các phần tử từ 9 trở về trước (9 > 1), (6 > 1), (4 > 1), (3 > 1)
//            Chèn "1" vào đầu mảng
//        B6: Mảng sau khi sắp xếp chèn [1,3,4,6,9]

        System.out.println("After insertion sort :" + Arrays.toString(arr));
    }
}
