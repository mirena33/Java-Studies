import java.util.Scanner;

public class middleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddle(input);

    }

    static void printMiddle(String input) {

        if (input.length() % 2 == 0) {

            char mid = input.charAt(input.length() / 2 - 1);
            char secondMid = input.charAt(input.length() / 2);

            System.out.printf("%c%c", mid, secondMid);


        } else {

            char mid = input.charAt(input.length() / 2);
            System.out.println(mid);
        }


    }
}
