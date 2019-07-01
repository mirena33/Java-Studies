import java.util.Scanner;

public class vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double excursionMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());
        int dayCounter = 0;
        int spendCounter = 0;

        while (true) {
            String action = scanner.nextLine();
            double dayMoney = Double.parseDouble(scanner.nextLine());
            dayCounter++;


            if (action.equals("spend")) {
                spendCounter++;
                availableMoney -= dayMoney;
                if (dayMoney > availableMoney) {
                    availableMoney = 0;
                }
            } else if (action.equals("save")) {
                spendCounter = 0;
                availableMoney += dayMoney;

            }

            if (availableMoney >= excursionMoney) {
                System.out.printf("You saved the money for %d days.", dayCounter);
                return;
            }

            if (spendCounter >= 5) {
                System.out.println("You can't save the money.");
                System.out.println(dayCounter);
                break;
            }
        }

    }
}