import java.util.Scanner;

public class ladyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[] field = new int[size];

        String[] initialIndexesString = scanner.nextLine().split(" ");
        int[] intialIndex = new int[initialIndexesString.length];

        for (int i = 0; i < intialIndex.length; i++) {
            intialIndex[i] = Integer.parseInt(initialIndexesString[i]);
        }


        String[] command = scanner.nextLine().split(" ");


        while (!command.equals("end")) {

            int ladybugIndex = Integer.parseInt(command[0]);
            String direction = command[1];
            int flyLength = Integer.parseInt(command[2]);




            command = scanner.nextLine().split(" ");
        }

    }
}
