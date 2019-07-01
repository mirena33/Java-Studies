import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] initialIndexesAsString = scanner.nextLine().split("\\s+");

        int[] initialIndex = new int[initialIndexesAsString.length];

        for (int i = 0; i < initialIndex.length; i++) {
            initialIndex[i] = Integer.parseInt(initialIndexesAsString[i]);

        }

        String input = "";

        while (!"end".equals(input = scanner.nextLine())) {
            String[] command = scanner.nextLine().split("\\s+");

            int currentPosition = Integer.parseInt(command[0]);
            String direction = command[1];
            int flyLength = Integer.parseInt(command[2]);



            switch (direction) {
                case "left":

                    break;

                case "right":

                    break;

                default:
                    break;
            }

        }


    }
}
