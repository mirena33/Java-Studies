import java.util.Scanner;

public class charityCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int bakers = Integer.parseInt(scanner.nextLine());

        int cakes = Integer.parseInt(scanner.nextLine());
        int waffles = Integer.parseInt(scanner.nextLine());
        int pancakes = Integer.parseInt(scanner.nextLine());

        int countCake = cakes * 45;
        double countWaffles = waffles * 5.8;
        double countPancakes = pancakes * 3.2;

        double sum = (countCake + countWaffles + countPancakes) * bakers;
        double wholeCampaign = sum * days;

        double costs = wholeCampaign - (wholeCampaign / 8);

        System.out.printf("%.2f", costs);

    }
}
