import java.util.Scanner;

public class kaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String input = "";
        int bestSequenceIndex = 0;

        while (!"Clone them!".equals(input = scanner.nextLine())) {

            String[] data = input.split("!+");
            int[] sequenceDNA = new int[size];
            int index = 0;

            for (int i = 0; i < data.length; i++) {
                sequenceDNA[index++] = Integer.parseInt(data[i]);
            }

            int maxCount = 0;
            int sequenceIndex = 0;

            for (int i = 0; i < sequenceDNA.length; i++) {

                int currentCount = 0;

                for (int j = i; j < sequenceDNA.length; j++) {

                    if (sequenceDNA[i] == sequenceDNA[j]) {
                        currentCount++;

                        if (currentCount > maxCount) {

                            maxCount = currentCount;
                            sequenceIndex = i;
                        }
                    } else {
                        break;
                    }
                }
            }

        }
    }
}
