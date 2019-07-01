import java.util.Scanner;

public class topNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= number; i++) {
            if (hasOneOddDigit(i) && isDigitsIsDivisibleBy8(i)) {
                System.out.println(i);
            }
        }

    }

    private static boolean hasOneOddDigit(int number) {

        String num = String.valueOf(number);

        for (int i = 0; i < num.length(); i++) {
            if (Integer.parseInt(String.valueOf(num.charAt(i))) % 2 == 1) {
                return true;
            }
        }

        return false;
    }

    private static boolean isDigitsIsDivisibleBy8(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        if (sum % 8 == 0) {
            return true;
        }

        return false;
    }
}
