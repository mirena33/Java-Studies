import java.util.Scanner;

public class dungeonestDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int coins = 0;
        int bestRoom = 0;

        String[] rooms = scanner.nextLine().split("[|]");


        for (int i = 0; i < rooms.length; i++) {

            String[] roomData = rooms[i].split("\\s+");

            String firstToken = roomData[0];
            int tokenValue = Integer.parseInt(roomData[1]);

            if (firstToken.equals("potion")) {
                if (health + tokenValue > 100) {
                    tokenValue = 100 - health;
                }

                health += tokenValue;

                System.out.println("You healed for " + tokenValue + " hp.");
                System.out.println("Current health: " + health + " hp.");

            } else if (firstToken.equals("chest")) {

                System.out.println("You found " + tokenValue + " coins.");

                coins += tokenValue;

            } else {
                health -= tokenValue;

                if (health > 0) {
                    System.out.println("You slayed " + firstToken + ".");
                } else {
                    System.out.println("You died! Killed by " + firstToken + ".");

                    bestRoom = i + 1;
                    break;
                }
            }

        }

        if (health <= 0){
            System.out.println("Best room: " + bestRoom);

        } else {

            System.out.println("You've made it!");
            System.out.println("Coins: " + coins);
            System.out.println("Health: " + health);

        }

    }
}
