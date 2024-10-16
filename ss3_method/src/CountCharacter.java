import java.util.Scanner;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println("Enter a string: ");
        str = sc.nextLine();

        char ch;
        System.out.println("Enter a character: ");
        ch = sc.next().charAt(0);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                count++;
            }
        }
        System.out.println("The number of occurrences of a character" + ch + " in a string: " + count);
    }

}
