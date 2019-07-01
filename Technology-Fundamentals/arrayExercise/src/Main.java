import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());

        }

        for (int i = 0; i < numbers.length ; i++) {
            System.out.print(numbers[i] + " ");
        }

       System.out.println(Arrays.stream(numbers).sum());
    }
}
