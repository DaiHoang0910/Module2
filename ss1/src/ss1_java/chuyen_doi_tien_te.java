package ss1_java;

import java.util.Scanner;

public class chuyen_doi_tien_te {
    public static void main(String[] args) {
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập số tiền USD cần quy đổi: ");
        usd = sc.nextDouble();
        double quydoi = usd * 23000;
        System.out.println("Giá trị VND nhận được tương ứng: " + quydoi);
    }
}
