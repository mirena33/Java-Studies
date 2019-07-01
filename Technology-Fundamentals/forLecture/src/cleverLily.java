import java.util.Scanner;

public class cleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        double priceWasher = Double.parseDouble(scanner.nextLine());
        double pricePerToy = Double.parseDouble(scanner.nextLine());

        int sum = 0;
        int countToy = 0;
        int countBrother = 0;
        int money = 10;

        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                sum += money;
                money += 10;
                countBrother++;

            } else {
                countToy++;
            }
        }
        double savedMoney = (sum - countBrother) + (countToy * pricePerToy);
        if (savedMoney >= priceWasher) {
            System.out.printf("Yes! %.2f", savedMoney - priceWasher);
        } else {
            System.out.printf("No! %.2f", Math.abs(savedMoney - priceWasher));
        }
    }
}
