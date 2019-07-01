import java.util.Scanner;

public class zigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] numbers = new String[n * 2];

        int index = 0;

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");


            if (i % 2 == 0) {
                numbers[index++] = input[0];
                numbers[index++] = input[1];

            } else {
                numbers[index++] = input[1];
                numbers[index++] = input[0];
            }
        }
        String firstOutput = "";
        String secondOutput = "";

        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                firstOutput = firstOutput + numbers[i] + " ";
            } else {
               secondOutput = secondOutput + numbers[i] + " ";
            }
        }

        System.out.println(firstOutput);
        System.out.println(secondOutput);

    }
}
