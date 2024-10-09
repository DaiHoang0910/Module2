package ss1_java;

import java.util.Scanner;

public class chuyen_so_thanh_chu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập số cần chuyển đổi thành chữ: ");
        String input = sc.nextLine();
        String[] inputRay = input.split(" ");
        switch (inputRay.length -1 ) {
            case 1:
                if (inputRay[1].equals("0")) {
                    System.out.println("zero");
                } else {
                    System.out.println(tenDown(inputRay[1]));
                }
                break;
            case 2:
                System.out.println(tenUp(inputRay[1], tenDown(inputRay[2])));
                break;
            case 3:
                if ((inputRay[2].equals("0")) && (inputRay[3].equals("0"))) {
                    System.out.println(hundredUp(inputRay[1]));
                } else {
                    System.out.print(hundredUp(inputRay[1]));
                    System.out.print(" and" + tenUp(inputRay[2], tenDown(inputRay[3])) + "\n");
                }
        }

    }

    private static String tenDown(String number) {
        switch (number) {
            case "0":
                return "";
            case "1":
                return "one";
            case "2":
                return "two";
            case "3":
                return "three";
            case "4":
                return "four";
            case "5":
                return "five";
            case "6":
                return "six";
            case "7":
                return "seven";
            case "8":
                return "eight";
            case "9":
                return "nine";
            default:
                return "can't read this";
        }
    }

    private static String tenUp(String number, String previous) {
        switch (number) {
            case "0":
                return previous;
            case "1":
                switch (previous) {
                    case "":
                        return "ten";
                    case "one":
                        return "eleven";
                    case "two":
                        return "twelve";
                    case "three":
                        return "thirteen";
                    default:
                        return previous + "teen";
                }
            case "2":
                return "twenty" + previous;
            case "3":
                return "thirty" + previous;
            default:
                return tenDown(number) + "ty" + " " + previous;
        }

    }

    private static String hundredUp(String number) {
        return tenDown(number) + "hundred";
    }
}
