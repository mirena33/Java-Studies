import java.util.Scanner;

public class sumOfOddNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int sum = 0;

        for (int j = 1; j <= 100; j++) {

            if (counter == number) {
                break;
            }
            if (j % 2 == 1) {
                counter++;
                sum += j;
                System.out.println(j);
            }


        }

        System.out.printf("Sum: %d", sum);
    }
}
