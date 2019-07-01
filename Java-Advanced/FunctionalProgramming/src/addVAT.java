import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class addVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] prices = scanner.nextLine().split(", ");

        UnaryOperator<Double> addVat = d -> d * 1.2;

        System.out.println("Prices with VAT: ");

        Arrays.stream(prices)
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(e -> System.out.println(String.format("%.2f", e)));


    }
}
