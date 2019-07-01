import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeizetheFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("#");
        int water = Integer.parseInt(scanner.nextLine());

        double totalEffort = 0.0;
        int totalFire = 0;
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < input.length; i++) {

            double currentEffort = 0.0;

            String[] data = input[i].split(" = ");


            String intialCell = data[0];
            int intialRange = Integer.parseInt(data[1]);

            if (intialCell.equals("High")) {
                if (intialRange >= 81 && intialRange <= 125) {

                    if (water - intialRange < 0) {

                        continue;
                    } else {
                        water -= intialRange;
                        totalFire += intialRange;
                        list.add(intialRange);
                        currentEffort = intialRange * 0.25;
                    }
                }

            } else if (intialCell.equals("Medium")) {
                if (intialRange >= 51 && intialRange <= 80) {

                    if (water - intialRange < 0) {

                        continue;
                    } else {
                        water -= intialRange;
                        totalFire += intialRange;
                        list.add(intialRange);
                        currentEffort = intialRange * 0.25;
                    }

                }


            } else if (intialCell.equals("Low")) {
                if (intialRange >= 1 && intialRange <= 50) {

                    if (water - intialRange < 0) {

                        continue;
                    } else {
                        water -= intialRange;
                        totalFire += intialRange;
                        list.add(intialRange);
                        currentEffort = intialRange * 0.25;
                    }

                }


            }
            totalEffort += currentEffort;

        }

        System.out.println("Cells:");

        for (int i = 0; i < list.size(); i++) {
            System.out.printf(" - %d\n", list.get(i));
        }

        System.out.printf("Effort: %.2f\n", totalEffort);
        System.out.printf("Total Fire: %d", totalFire);

    }
}
