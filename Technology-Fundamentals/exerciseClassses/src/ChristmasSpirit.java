import java.util.Scanner;

public class ChristmasSpirit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int christmasSpirit = 0;
        int sum = 0;


        for (int i = 1; i <= days; i++) {

            if (i % 11 == 0) {
                quantity += 2;
            }
            if (i % 10 == 0) {
                christmasSpirit -= 20;
                sum += 23;

            }
            if (i % 5 == 0) {
                sum += (15 * quantity);
                christmasSpirit += 17;

                if (i % 3 == 0) {
                    christmasSpirit += 30;
                }

            }
            if (i % 3 == 0) {
                sum += (5 * quantity) + (3 * quantity);
                christmasSpirit += 13;


            }

            if (i % 2 == 0) {
                sum += (2 * quantity);
                christmasSpirit += 5;
            }


            if (i == 10 && days % 10 == 0) {
                christmasSpirit -= 30;
            }
        }

        System.out.println("Total cost: " + sum);
        System.out.println("Total spirit: " + christmasSpirit);
    }
}
