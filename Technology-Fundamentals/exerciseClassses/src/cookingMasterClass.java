import java.util.Scanner;

public class cookingMasterClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceFlourPackage = Double.parseDouble(scanner.nextLine());
        double pricePerEgg = Double.parseDouble(scanner.nextLine());
        double pricePerApron = Double.parseDouble(scanner.nextLine());

        double sum = 0;

        int freePackages = students;

        for (int i = 1; i <= students; i++) {

            if (i % 5 == 0) {
                freePackages--;
            }

        }


        sum = (priceFlourPackage * freePackages) + (pricePerEgg * 10 * students)
                + (pricePerApron * (Math.ceil(students * 0.2) + students));

        if (sum <= budget) {
            System.out.printf("Items purchased for %.2f$.", sum);
        } else {
            System.out.printf("%.2f$ more needed.", sum - budget);
        }
    }
}
