package bai_tap.Validate_class;

import java.util.Scanner;

public class Test {
    private static ClassName className;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập tên lớp:");
        String nameClass = sc.nextLine();
        className = new ClassName();
        boolean isValid = className.validate(nameClass);
        if (isValid) {
            System.out.println("Tên hợp lệ");
        }else{
            System.out.println("Tên không hợp lệ");
        }
    }
}
