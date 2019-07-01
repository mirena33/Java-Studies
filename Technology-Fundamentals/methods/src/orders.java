import java.util.Scanner;

public class orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        double quantity = Integer.parseInt(scanner.nextLine());

        getPrice(product, quantity);
    }

    private static void getPrice(String product, double quantity) {

        double totalPrice = 0;

        switch (product) {
            case "coffee":
                totalPrice = 1.50 * quantity;
                break;
            case "water":
                totalPrice = 1.00 * quantity;
                break;
            case "coke":
                totalPrice = 1.40 * quantity;
                break;
            case "snacks":
                totalPrice = 2.00 * quantity;
                break;

            default:
                break;
        }

        System.out.printf("%.2f", totalPrice);
    }
}
