import java.util.Arrays;
import java.util.Scanner;

public class Delete {
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
            System.out.printf("arr[] = ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("Nhập phần tử cần xóa: ");
        int num = sc.nextInt();
        System.out.println(delete(arr, num));
//        int [] arr1 = new int[arr.length - 1];
//        int indexDel = 0;
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i] != num){
//                arr1[indexDel] = arr[i];
//                indexDel++;
//            }
//        }
//        System.out.println(Arrays.toString(arr1));
    }
    public static String delete(int[] arr, int num){
        int [] arr1 = new int[arr.length - 1];
        int indexDel = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != num){
                arr1[indexDel] = arr[i];
                indexDel++;
            }
        }
        return Arrays.toString(arr1);
    }
}
