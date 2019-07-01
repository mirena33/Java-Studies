import java.util.Scanner;

public class strongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberInput = scanner.nextLine();

        long sum = 0;

        for (int i = 0; i < numberInput.length(); i++) {
            int number = Integer.parseInt(String.valueOf(numberInput.charAt(i)));

            int factorial = 1;
            for (int j = 1; j <= number; j++) {
                factorial *= j;
            }
            sum += factorial;
        }

        if  (numberInput.equals(String.valueOf(sum))) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        //the same output:
        // String result = numberInput.equals(String.valueOf(sum) ? "yes" : "no";

    }
}
