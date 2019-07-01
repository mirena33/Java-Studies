import java.util.Scanner;

public class arrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations % numbers.length; i++) {
            String firstElement = numbers[0];

            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }

            numbers[numbers.length - 1] = firstElement;
        }

        System.out.println(String.join(" ", numbers));
    }
}
