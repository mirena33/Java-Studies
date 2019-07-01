import java.util.Scanner;

public class maxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsStrings = scanner.nextLine().split(" ");

        int[] sequence = new int[numbersAsStrings.length];

        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = Integer.parseInt(numbersAsStrings[i]);

        }

        int maxCount = 0;
        int bestSequence = 0;

        for (int i = 0; i < sequence.length; i++) {

            int currentCount = 0;

            for (int j = i; j < sequence.length; j++) {

                if (sequence[i] == sequence[j]) {

                    currentCount++;

                    if (currentCount > maxCount) {

                        maxCount = currentCount;
                        bestSequence = sequence[i];
                    }
                } else {
                    break;
                }

            }
        }

        for (int i = 0; i < maxCount ; i++) {
            System.out.print(bestSequence + " ");
        }


    }
}
