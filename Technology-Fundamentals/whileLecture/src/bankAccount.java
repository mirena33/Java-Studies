import java.util.Scanner;

public class bankAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOperation = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        double totalSum = 0.0;

        while (!(counter == countOperation))  {
            double currentSum = Double.parseDouble(scanner.nextLine());
            if (currentSum < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n", currentSum);
            totalSum = totalSum + currentSum;
            counter++;

        }
        System.out.printf("Total: %.2f ",totalSum);

    }
}
