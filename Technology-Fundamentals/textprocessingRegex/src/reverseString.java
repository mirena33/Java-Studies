import java.util.Scanner;

public class reverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        while (!"end".equals(input)) {
            String result = "";
            for (int i = input.length() - 1; i >= 0; i--) {

                result += input.charAt(i);

            }
            System.out.printf("%s = %s\n", input, result);
            input = scanner.nextLine();
        }
    }
}
