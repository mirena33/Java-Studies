import java.util.Scanner;

public class fishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fisherNum = Integer.parseInt(scanner.nextLine());
        double neededMoney = 0.0;

        switch (season) {
            case "Spring":

                if (fisherNum <= 6) {
                    neededMoney = 3000 - (3000 * 0.1);
                } else if (fisherNum <= 11) {
                    neededMoney = 3000 - (3000 * 0.15);
                } else if (fisherNum >= 12) {
                    neededMoney = 3000 - (3000 * 0.25);
                }
                if (fisherNum%2==0) {
                    neededMoney = neededMoney - (neededMoney * 0.05);
                }

                break;

            case "Summer":

                if (fisherNum <= 6) {
                    neededMoney = 4200 - (4200 * 0.1);
                } else if (fisherNum <= 11) {
                    neededMoney = 4200 - (4200 * 0.15);
                } else if (fisherNum >= 12) {
                    neededMoney = 4200 - (4200 * 0.25);
                }
                if (fisherNum%2==0) {
                    neededMoney = neededMoney - (neededMoney * 0.05);
                }

                break;

            case "Autumn":

                if (fisherNum <= 6) {
                    neededMoney = 4200 - (4200 * 0.1);
                } else if (fisherNum <= 11) {
                    neededMoney = 4200 - (4200 * 0.15);
                } else if (fisherNum >= 12) {
                    neededMoney = 4200 - (4200 * 0.25);
                }

                break;

            case "Winter":

                if (fisherNum <= 6) {
                    neededMoney = 2600 - (2600 * 0.1);
                } else if (fisherNum <= 11) {
                    neededMoney = 2600 - (2600 * 0.15);
                } else if (fisherNum >= 12) {
                    neededMoney = 2600 - (2600 * 0.25);
                }
                if (fisherNum%2==0) {
                    neededMoney = neededMoney - (neededMoney * 0.05);
                }

                break;
        }

        if (budget >= neededMoney) {
            System.out.printf("Yes! You have %.2f leva left.", budget - neededMoney);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(neededMoney - budget));
        }




    }
}
