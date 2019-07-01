import java.util.Scanner;

public class breadFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = 100;
        int coins = 100;
        String cannotAfford = "";

        String[] events = scanner.nextLine().split("[|]");

        for (int i = 0; i < events.length; i++) {
            String[] input = events[i].split("-");

            String command = input[0];
            int token = Integer.parseInt(input[1]);

            if ("rest".equals(command)) {
                if (energy + token > 100) {
                    token = 100 - energy;
                }

                energy += token;

                System.out.printf("You gained %d energy.\n", token);
                System.out.printf("Current energy: %d.\n", energy);

            } else if ("order".equals(command)) {

                if (energy - 30 >= 0) {

                    coins += token;
                    energy -= 30;

                    System.out.printf("You earned %d coins.\n", token);

                } else if (energy - 30 < 0){
                    energy += 50;
                    System.out.println("You had to rest!");
                }
            } else {
                coins -= token;

                if (coins >= 0) {

                    System.out.printf("You bought %s.\n", command);

                } else {
                    cannotAfford = command;
                    break;
                }
            }


        }

        if (coins >= 0) {

            System.out.println("Day completed!");
            System.out.println("Coins: " + coins);
            System.out.println("Energy: " + energy);
        } else {
            System.out.printf("Closed! Cannot afford %s.\n", cannotAfford);
        }
    }
}
