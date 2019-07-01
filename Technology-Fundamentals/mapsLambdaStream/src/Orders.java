import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();

        String input = "";

        while (!"buy".equals(input = scanner.nextLine())) {

            String[] data = input.split("\\s+");

            String productName = data[0];
            double price = Double.parseDouble(data[1]);
            int quantity = Integer.parseInt(data[2]);

            if (!productsPrice.containsKey(productName)) {

                productsPrice.put(productName, price);
                productsQuantity.put(productName, quantity);

            } else {
                productsPrice.put(productName, price);
                productsQuantity.put(productName, productsQuantity.get(productName) + quantity);
            }

        }


        productsPrice
                .entrySet()
                .stream()
                .forEach(kvp -> {
                    System.out.println(String.format("%s -> %.2f",
                            kvp.getKey(), kvp.getValue() * productsQuantity.get(kvp.getKey())));
                });

    }
}
