import java.util.Scanner;

public class palindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

    while (!number.equals("END")) {

        if (number.equals(palindrome(number))) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        number = scanner.nextLine();
    }

    }

    static String palindrome(String number) {
        String reverse = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            reverse += number.charAt(i);
        }
        return reverse;
    }
}
