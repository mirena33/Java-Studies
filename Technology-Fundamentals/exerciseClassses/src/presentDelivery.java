import java.util.Arrays;
import java.util.Scanner;

public class presentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] houses = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = "";
        int currentPosition = 0;
        int lastPositionIndex = 0;

        while (!"Merry Xmas!".equals(input = scanner.nextLine())) {

            String[] command = input.split("\\s+");
            int jumpLength = Integer.parseInt(command[1]);

            if (command[0].equals("Jump")) {

                for (int i = 0; i < houses.length; i++) {
                    if (jumpLength + currentPosition >= 0 && jumpLength + currentPosition < houses.length) {

                        currentPosition += jumpLength;
                    } else {
                        currentPosition = (currentPosition + jumpLength) % houses.length;
                    }

                    lastPositionIndex = currentPosition;

                    if (houses[currentPosition] == 0) {
                        System.out.printf("House %d will have a Merry Christmas.\n", currentPosition);
                        break;

                    } else {
                        houses[currentPosition] -= 2;
                        break;
                    }


                }
            }
        }

        int failedHouses = 0;

        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != 0) {
                failedHouses++;
            }
        }

        System.out.printf("Santa's last position was %d.\n", lastPositionIndex);

        if (failedHouses == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Santa has failed %d houses.", failedHouses);
        }


    }
}
