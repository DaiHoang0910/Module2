package ss1_java;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        double exchange;
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập số tiền USD cần quy đổi: ");
        exchange = sc.nextDouble();
        if (exchange < 0) {
            System.out.println("Lỗi");
        } else {
            double usd = exchange * 23000;
            System.out.println("Giá trị VND nhận được tương ứng: " + usd);
        }
    }
}
