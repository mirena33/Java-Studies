import java.util.Scanner;

public class vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupNumber = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine().toLowerCase();
        String day = scanner.nextLine().toLowerCase();

        double price = 0.0;

        if (groupNumber >= 100 && groupType.equals("business")) {
            groupNumber -= 10;
        }


        switch (day) {

            case "friday":
                if (groupType.equals("students")) {
                    price = groupNumber * 8.45;
                } else if (groupType.equals("business")) {
                    price = groupNumber * 10.90;
                } else if (groupType.equals("regular")) {
                    price = groupNumber * 15;
                }

                break;

            case "saturday":

                if (groupType.equals("students")) {
                    price = groupNumber * 9.80;
                } else if (groupType.equals("business")) {
                    price = groupNumber * 15.60;
                } else if (groupType.equals("regular")) {
                    price = groupNumber * 20;
                }

                break;

            case "sunday":

                if (groupType.equals("students")) {
                    price = groupNumber * 10.46;
                } else if (groupType.equals("business")) {
                    price = groupNumber * 16;
                } else if (groupType.equals("regular")) {
                    price = groupNumber * 22.50;
                }

                break;
            default:
                break;

        }
        if (groupNumber >= 30 && groupType.equals("students")) {
            price -= price * 0.15;
        }
        else if ((groupNumber >= 10 && groupNumber <= 20) && groupType.equals("regular")) {
            price -= price * 0.05;
        }

        System.out.println(String.format("Total price: %.2f", price));
    }
}
