import java.util.Arrays;
import java.util.Scanner;

public class exercise {

    //CONDENSED NUMBERS

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] condensed = new int[numbers.length - 1];

        if (numbers.length == 1) {

            System.out.println(numbers[0]);

        } else {

            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < condensed.length - i; j++) {

                    condensed[j] = numbers[j] + numbers[j + 1];

                }

                numbers = condensed;
            }
            System.out.println(condensed[0]);
        }

    }
}
