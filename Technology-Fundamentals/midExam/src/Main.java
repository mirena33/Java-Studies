import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int playersCount = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double dailyWaterPerPerson = Double.parseDouble(scanner.nextLine());
        double dailyFoodPerPerson = Double.parseDouble(scanner.nextLine());

        double totalWater = days * dailyWaterPerPerson * playersCount;
        double totalFood = days * dailyFoodPerPerson * playersCount;

        double leftFood = 0.0;
        double leftWater = 0.0;

        if (playersCount <= 0){
            return;
        }

        for (int i = 1; i <= days; i++) {
            double energyLoss = Double.parseDouble(scanner.nextLine());

            leftFood = totalFood;
            leftWater = totalWater;

            groupEnergy -= energyLoss;

            if (groupEnergy <= 0) {
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",
                        leftFood, leftWater);
                return;
            }

            if (i % 3 == 0) {
                totalFood = totalFood - (totalFood / playersCount);
                groupEnergy = (groupEnergy * 0.1) + groupEnergy;
            }

            if (i % 2 == 0) {
                groupEnergy = (0.05 * groupEnergy) + groupEnergy;
                totalWater = totalWater - (0.3 * totalWater);
            }


        }

        System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);

    }
}
