package bai_tap.Validate_phonenumber;

import java.util.Scanner;

public class Test {
    private static PhoneNumber phoneNumber;
    public static void main(String[] args) {
        phoneNumber = new PhoneNumber();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();
        boolean isValid = phoneNumber.validate(phone);
        if (isValid) {
            System.out.println("Phone number is valid");
        }else {
            System.out.println("Phone number is not valid");
        }
    }
}
