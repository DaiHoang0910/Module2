import java.util.Arrays;
import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        while (n < 0){
            System.out.println("Lỗi");
            System.out.println("Nhập số phần tử của mảng: ");
            n = sc.nextInt();
        }
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.printf("arr[%d] = ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("Nhập số cần thêm");
        int num = sc.nextInt();

        arr = add(arr, num);
        System.out.println("Mảng với phần tử "+ num +" được thêm vào: " + Arrays.toString(arr));
    }
    public static int[] add(int[] arr, int num){
        int [] newArr = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        newArr[arr.length] = num;
        return newArr;
    }
}
