import java.util.Scanner;

public class equalSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsString = scanner.nextLine().split(" ");

        int[] numbers = new int[numbersAsString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }


        for (int i = 0; i < numbers.length; i++) {

            int leftSum = 0;

            for (int j = 0; j < i ; j++) {
                leftSum += numbers[j];
            }
            
            int rightSum = 0;

            for (int j = i + 1; j <numbers.length ; j++) {
                rightSum += numbers[j];
            }

            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }
        }

        System.out.println("no");
    }
}
