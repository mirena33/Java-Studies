import java.util.Scanner;

public class arraysExerciseAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsString = scanner.nextLine().split(" ");

        int[] numbers = new int[numbersAsString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);

            
        }

        for (int i = 0; i < numbers.length ; i++) {

            boolean isGreater = true;

            for (int j = i + 1; j < numbers.length ; j++) {

                if (numbers[i] <= numbers[j]) {

                    isGreater = false;
                    break;
                }
                
            }

            if (isGreater) {
                System.out.print(numbers[i] + " ");
            }
        }
  
    }
}
