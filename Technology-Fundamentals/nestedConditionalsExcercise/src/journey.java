import java.util.Scanner;

public class journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = "";

        if (budget >= 0 && budget <= 100) {
            System.out.println("Somewhere in Bulgaria");
            if ("summer".equals(season)) {
                budget = budget * 0.30;
                place = "Camp";
            } else if ("winter".equals(season)) {
                budget = budget * 0.70;
                place = "Hotel";
            }
        }else if (budget <= 1000) {
            System.out.println("Somewhere in Balkans");
            if ("summer".equals(season)) {
                budget = budget * 0.40;
                place = "Camp";
            } else if ("winter".equals(season)) {
                budget = budget * 0.80;
                place = "Hotel";
            }
        } else if (budget > 1000) {
            System.out.println("Somewhere in Europe");
            budget = budget * 0.90;
            place = "Hotel";
        }

        System.out.printf("%s - %.2f", place, budget);
    }
}
